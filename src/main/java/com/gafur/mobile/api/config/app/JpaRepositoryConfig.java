package com.gafur.mobile.api.config.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * Конфигурация для работой с бд
 *
 * @author igafurov
 * @since 04.12.2017
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
@PropertySource(value = "classpath:application-database.properties")
public class JpaRepositoryConfig extends HikariConfig {

    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(this);
    }

}