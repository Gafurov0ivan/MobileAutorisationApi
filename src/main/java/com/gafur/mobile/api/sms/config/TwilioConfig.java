package com.gafur.mobile.api.sms.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация Twilio
 *
 * @author igafurov
 * @since 07.12.2017
 */
@Configuration
@ComponentScan(basePackages = "com.twilio.notifications")
public class TwilioConfig {
}