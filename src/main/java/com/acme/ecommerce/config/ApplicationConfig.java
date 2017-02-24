package com.acme.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
@PropertySource("file:${properties.home}/eCommerce.properties")
public class ApplicationConfig {

  //To resolve ${} in @Value
  @Bean
  public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
    PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
    configurer.setLocation(new ClassPathResource("eCommerce.properties"));
    return configurer;
  }

}
