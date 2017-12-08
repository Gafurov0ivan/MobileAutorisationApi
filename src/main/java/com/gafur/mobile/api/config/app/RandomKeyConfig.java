package com.gafur.mobile.api.config.app;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация для генерации рандомного ключа
 *
 * @author igafurov
 * @since 04.12.2017
 */
@Configuration
@ConfigurationProperties(prefix = "app.random")
@Data
public class RandomKeyConfig {
    private Integer size;
    private Integer partitionSize;
    private String delimiter;
    private Boolean withLetters;
}