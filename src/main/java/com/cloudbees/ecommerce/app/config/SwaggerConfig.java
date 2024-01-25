package com.cloudbees.ecommerce.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Swagger2 Configuration Class For Build-In API-Interaction Tool;
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Docket For Swagger2 Configuration;
     */
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.cloudbees.ecommerce.app")).build().apiInfo(metaData());
    }


    /**
     * MetaData For Swagger2 Configuration;
     */
    private ApiInfo metaData() {
        return new ApiInfoBuilder().title("CloudBees Pro")
                .description("\"Spring Boot REST API Application for CloudBees \"").version("1.0.0")
                .license("Apache License Version 2.0").licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .version("1.0.0")
                .contact(new Contact(
                        "Interview",
                        "https://www.linkedin.com/in/shubham-sharma-94746a174/",
                        "subham3140@gmail.com"))
                .termsOfServiceUrl("Internal use only")
                .build();
    }

}
