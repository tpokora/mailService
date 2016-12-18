package com.tpokora.common;

import com.tpokora.config.AppTestConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by pokor on 17.12.2016.
 */
@ContextConfiguration(classes = { AppTestConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractTest extends AbstractJUnit4SpringContextTests {
}
