package com.tpokora.mailservice.email.web;

import com.tpokora.mailservice.email.EmailHtmlSender;
import com.tpokora.mailservice.email.EmailStatus;
import com.tpokora.mailservice.email.model.EmailSendStatusResponse;
import com.tpokora.mailservice.email.model.SendMailForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;

/**
 * Created by pokor on 17.12.2016.
 */
@RestController
@RequestMapping("/mailservice")
public class EmailController {

    private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

    @Autowired
    private EmailHtmlSender emailHtmlSender;

    @RequestMapping(value = "/resetPasswordMail", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<EmailSendStatusResponse> hello(@RequestBody SendMailForm sendMailForm) throws Exception {
        logger.info("Sending email to reset password to: '{}'", sendMailForm.getTo());

        Context context = new Context();
        context.setVariable("title", "test");
        context.setVariable("description", "test description");

        EmailStatus emailStatus = emailHtmlSender.send(sendMailForm.getTo(), sendMailForm.getType(), "email/resetPasswordEmail", context);

        EmailSendStatusResponse emailSendStatusResponse = new EmailSendStatusResponse(sendMailForm.getTo(), emailStatus.getStatus());
        return new ResponseEntity<EmailSendStatusResponse>(emailSendStatusResponse, HttpStatus.OK);
    }
}
