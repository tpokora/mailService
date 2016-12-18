package com.tpokora.mailservice.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

/**
 * Created by pokor on 18.12.2016.
 */
@Component
public class EmailHtmlSender {

    @Autowired
    private EmailSender emailSender;

    @Autowired
    private SpringTemplateEngine springTemplateEngine;

    public EmailStatus send(String to, String subject, String templateName, Context context) {
        String body = springTemplateEngine.process(templateName, context);
        return emailSender.sendHtml(to, subject, body);
    }
}
