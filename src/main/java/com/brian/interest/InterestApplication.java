package com.brian.interest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point for the Spring Boot application.
 * @SpringBootApplication tells Spring to scan this package (and subpackages)
 * for @RestController and @Service annotations to build the application context.
 */
@SpringBootApplication
public class InterestApplication {

    public static void main(String[] args) {
        // Starts the embedded Tomcat server and loads all configurations
        SpringApplication.run(InterestApplication.class, args);
        System.out.println("🚀 Interest Engine API is now running on http://localhost:8080");
    }
}
