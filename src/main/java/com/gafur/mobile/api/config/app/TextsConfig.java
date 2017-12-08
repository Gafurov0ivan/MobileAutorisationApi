package com.gafur.mobile.api.config.app;

import com.gafur.mobile.api.rest.model.SmsTemplateDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация для sms template
 *
 * @author igafurov
 * @since 04.12.2017
 */
@Configuration
@ConfigurationProperties(prefix = "app.text")
public class TextsConfig extends SmsTemplateDto {
}
