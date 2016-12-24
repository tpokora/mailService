package com.tpokora.mailservice.email.web;

import com.tpokora.mailservice.email.model.EmailStatusEntity;
import com.tpokora.mailservice.email.service.EmailStatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * Created by pokor on 24.12.2016.
 */
@RestController
@RequestMapping("rest/emailstatus")
public class EmailStatusController {

    private static final Logger logger = LoggerFactory.getLogger(EmailStatusController.class);

    @Autowired
    private EmailStatusService emailStatusService;

    @RequestMapping("/list")
    public ResponseEntity<List<EmailStatusEntity>> getEmailStatusList() {

        if (emailStatusService.getAllEmailStatuses() == null) {
            return new ResponseEntity<List<EmailStatusEntity>>(Collections.emptyList(), HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<EmailStatusEntity>>(emailStatusService.getAllEmailStatuses(), HttpStatus.OK);
    }
}
