package com.gamestore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.util.Predicates;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
 
@EnableSwagger2
public class SwaggerConfiguration implements WebMvcConfigurer  
{
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(Predicates.negate(RequestHandlerSelectors.basePackage("org.springframework.boot")))
        .paths(PathSelectors.any())
        .build();
  }
 
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) 
  {
    registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
    registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
  }
}
