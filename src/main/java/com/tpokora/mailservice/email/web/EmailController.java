package com.tpokora.mailservice.email.web;

import com.tpokora.mailservice.email.Email;
import com.tpokora.mailservice.email.model.EmailStatusEntity;
import com.tpokora.mailservice.email.sender.EmailHtmlSender;
import com.tpokora.mailservice.email.sender.EmailStatus;
import com.tpokora.mailservice.email.model.EmailSendStatusResponse;
import com.tpokora.mailservice.email.model.SendMailForm;
import com.tpokora.mailservice.email.service.EmailStatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by pokor on 17.12.2016.
 */
@RestController
@RequestMapping("/mailservice")
public class EmailController {

    private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

    @Autowired
    private EmailHtmlSender emailHtmlSender;

    @Autowired
    private EmailStatusService emailStatusService;

    @RequestMapping(value = "/project-s/sendmail", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<EmailSendStatusResponse> hello(@RequestBody SendMailForm sendMailForm) throws Exception {
        logger.info("Sending email to reset password to: '{}'", sendMailForm.getTo());

        Email email = new Email(sendMailForm);
        EmailStatus emailStatus = emailHtmlSender.send(email);

        emailStatusService.saveEmailStatus(new EmailStatusEntity(email.getTo(), sendMailForm.getType(),emailStatus.getStatus(), new Date()));

        EmailSendStatusResponse emailSendStatusResponse = new EmailSendStatusResponse(sendMailForm.getTo(), emailStatus.getStatus());
        return new ResponseEntity<EmailSendStatusResponse>(emailSendStatusResponse, HttpStatus.OK);
    }
}
