package com.allianz.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
//@ComponentScan(basePackages = {"com.allianz.example.util", "com.allianz.example.controller","com.allianz.example.service", "com.allianz.example.database", "com.allianz.example.mapper", "com.allianz.example.model"})
public class ExampleApplication {

    public static void main(String[] args) {

        SpringApplication.run(ExampleApplication.class, args);
    }

}
/**
 * To change active profile enter:
 * -Dspring.profiles.active=dev
 */