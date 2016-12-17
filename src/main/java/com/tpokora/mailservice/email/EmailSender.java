package com.tpokora.mailservice.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

/**
 * Created by pokor on 16.12.2016.
 */
@Component
public class EmailSender {

    private static final Logger logger = LoggerFactory.getLogger(EmailSender.class);

    @Autowired
    private JavaMailSender javaMailSender;

    public EmailStatus sendEmail(String to, String subject, String text) {
        try {
            MimeMessage mail = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, false);
            javaMailSender.send(mail);
            logger.info("Send mail '{}' to: '{}'", subject, to);
            return new EmailStatus(to, subject, text).success();
        } catch (Exception e) {
            logger.error("Error during sending email: {}", e.getMessage());
            return new EmailStatus(to, subject, text).error(e.getMessage());
        }
    }

}
