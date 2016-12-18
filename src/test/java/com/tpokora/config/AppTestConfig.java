package com.tpokora.config;

import com.tpokora.mailservice.config.AppConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by pokor on 17.12.2016.
 */
@Configuration
@PropertySource("classpath:properties/dev.properties")
public class AppTestConfig extends AppConfig {
}
