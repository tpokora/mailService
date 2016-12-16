package com.tpokora.mailService.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by pokor on 16.12.2016.
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.tpokora.mailService" })
@EnableAutoConfiguration
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
