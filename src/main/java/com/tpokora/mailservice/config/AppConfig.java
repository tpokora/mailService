package com.tpokora.mailservice.config;

import com.tpokora.mailservice.email.sender.EmailHtmlSender;
import com.tpokora.mailservice.email.sender.EmailSender;
import com.tpokora.mailservice.email.service.EmailStatusService;
import com.tpokora.mailservice.email.service.EmailStatusServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by pokor on 17.12.2016.
 */
@Configuration
public class AppConfig {

    // Service classes beans
    @Bean(name = "emailStatusService")
    public EmailStatusService getEmailStatusService() {
        return new EmailStatusServiceImpl();
    }

    // CORS
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:3000");
                // opening DEV application to request different then front end application - must be reconfigured in production system
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }
}
