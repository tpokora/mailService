package com.tpokora.mailservice.email.sender;

import com.tpokora.mailservice.email.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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

    public EmailStatus send(Email email) {
        String body = springTemplateEngine.process(email.getTemplateName(), email.getContext());
        return emailSender.sendHtml(email.getTo(), email.getSubject(), body);
    }
}
