package com.tpokora.mailservice.common;

import com.tpokora.mailservice.config.AppTestConfig;
import com.tpokora.mailservice.config.DatabaseTestConfiguration;
import com.tpokora.mailservice.email.sender.EmailSender;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by pokor on 17.12.2016.
 */
@ContextConfiguration(classes = {
        AppTestConfig.class,
        DatabaseTestConfiguration.class
})
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("classpath:properties/dev.properties")
public class AbstractTest {
}
