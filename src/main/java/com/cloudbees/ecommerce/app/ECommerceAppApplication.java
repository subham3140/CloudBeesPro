package com.cloudbees.ecommerce.app;

import com.cloudbees.ecommerce.app.model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * The E-Commerce AppApplication Application;
 */
@SpringBootApplication
public class ECommerceAppApplication {

    private static final Logger LOGGER = LogManager.getLogger(ECommerceAppApplication.class.getName());

    /**
     * Application's Main Function;
     *
     * @param args:- The String[]
     */
    public static void main(String[] args) {
        LOGGER.debug("Starting a embedded spring boot server..");
        SpringApplication.run(ECommerceAppApplication.class, args);
        LOGGER.debug("Closing the server.");
    }

}
