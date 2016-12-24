package com.tpokora.mailservice.email.service;

import com.tpokora.mailservice.common.AbstractTest;
import com.tpokora.mailservice.email.dao.EmailStatusRepository;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by pokor on 24.12.2016.
 */
public class EmailStatusServiceTest extends AbstractTest {

    private static final Logger logger = LoggerFactory.getLogger(EmailStatusServiceTest.class);

    @Autowired
    private EmailStatusRepository emailStatusRepository;

    @Test
    @Transactional
    @Rollback(true)
    public void getAllEmailStatus() {
        Assert.assertTrue(emailStatusRepository.findAll().size() > 0);
    }
}
