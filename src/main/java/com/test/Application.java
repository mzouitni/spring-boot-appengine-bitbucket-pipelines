package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.LifecycleProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.DefaultLifecycleProcessor;

@SpringBootApplication
@SpringBootConfiguration
@ComponentScan(basePackages = {"com.test"})
public class Application extends SpringBootServletInitializer {
  private static final Class<Application> application = Application.class;

  public static void main(String[] args) {
    new SpringApplication(application).run(args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
    return applicationBuilder.sources(application);
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
