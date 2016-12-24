package com.tpokora.mailservice.email.service;

import com.tpokora.mailservice.common.AbstractTest;
import com.tpokora.mailservice.email.dao.EmailStatusRepository;
import com.tpokora.mailservice.email.model.EmailStatusEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by pokor on 24.12.2016.
 */
public class EmailStatusServiceTest extends AbstractTest {

    private static final Logger logger = LoggerFactory.getLogger(EmailStatusServiceTest.class);

    @Autowired
    private EmailStatusService emailStatusService;

    private EmailStatusEntity emailStatusEntity;

    @Before
    public void setup() {
        emailStatusEntity = new EmailStatusEntity();
        emailStatusEntity.setEmail("test@test.com");
        emailStatusEntity.setAction("test");
        emailStatusEntity.setStatus("TEST");
        emailStatusEntity.setDate(new Date());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void getAllEmailStatus() {
        Assert.assertTrue(emailStatusService.getAllEmailStatuses().size() > 0);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void addEmailStatusToDB_success() {
        emailStatusService.saveEmailStatus(emailStatusEntity);
        Assert.assertTrue(emailStatusService.getEmailStatusesByEmail(emailStatusEntity.getEmail()).size() > 0);
    }
}
