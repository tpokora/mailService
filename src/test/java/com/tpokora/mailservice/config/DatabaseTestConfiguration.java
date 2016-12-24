package com.tpokora.mailservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by pokor on 24.12.2016.
 */
@Configuration
@PropertySource("classpath:properties/dev.properties")
public class DatabaseTestConfiguration extends DatabaseConfiguration {
}
