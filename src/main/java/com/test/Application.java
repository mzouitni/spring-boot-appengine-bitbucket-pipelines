package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.LifecycleProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.DefaultLifecycleProcessor;

@SpringBootApplication
@SpringBootConfiguration
@ComponentScan(basePackages = {"hello"})
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(new SpringApplication(Application.class), args);
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
}
