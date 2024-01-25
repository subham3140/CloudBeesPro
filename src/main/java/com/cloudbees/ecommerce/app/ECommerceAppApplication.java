package com.cloudbees.ecommerce.app;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
        LOGGER.info("Starting a embedded spring boot server..");
        SpringApplication.run(ECommerceAppApplication.class, args);
        LOGGER.info("Closing the server.");
    }

}
