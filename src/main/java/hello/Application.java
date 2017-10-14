package hello;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.LifecycleProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.DefaultLifecycleProcessor;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.annotation.PostConstruct;
import javax.validation.Validator;
import java.util.Arrays;

@SpringBootApplication
@SpringBootConfiguration
@ComponentScan(basePackages = {"hello"})
public class Application extends SpringBootServletInitializer {
    private static final Class<Application> application = Application.class;

    private UserVerticle userVerticle;
    private UserEventHandler userEventHandler;

    @Autowired
    public Application(UserVerticle userVerticle, UserEventHandler userEventHandler) {
        this.userVerticle = userVerticle;
        this.userEventHandler = userEventHandler;
    }

    /**
     * Creates a life cycle processor.
     *
     * @return newly created processor
     */
    @Bean
    public LifecycleProcessor lifecycleProcessor() {
        DefaultLifecycleProcessor processor = new DefaultLifecycleProcessor();
        processor.setTimeoutPerShutdownPhase(5000);
        return processor;
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(application);
    }

    /**
     * Creates bean validator.
     *
     * @return newly created validator
     */
    @Bean(name = "udpUserValidator")
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }

    /*public static void main(String args[]) {
        SpringApplication springApplication = new SpringApplication(application);
        springApplication.setBannerMode(OFF);
        ApplicationContext ctx = springApplication.run(args);
        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }*/

    @PostConstruct
    public void deployServerVerticle() {
        Vertx v = Vertx.vertx();
        Router r = Router.router(v);
        v.deployVerticle(userVerticle);
        v.deployVerticle(userEventHandler);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(application, args);
        
        System.out.println("Let's inspect the beans provided by Spring Boot:");
        
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }



}
