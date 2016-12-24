package com.tpokora.mailservice.config;

import com.tpokora.mailservice.email.sender.EmailHtmlSender;
import com.tpokora.mailservice.email.sender.EmailSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by pokor on 24.12.2016.
 */
@Configuration
public class EmailSenderConfig {

    @Bean(name = "emailSender")
    public EmailSender getEmailSender() {
        return new EmailSender();
    }

    @Bean(name = "emailHtmlSender")
    public EmailHtmlSender getEmailHtmlSender() {
        return new EmailHtmlSender();
    }
}
