package com.gafur.mobile.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Точка старта приложения
 *
 * @author igafurov
 * @since 26.11.2017
 */
@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
@Slf4j
public class Application {

    public static void main(String[] args) {
        log.debug("args: {}", args);
        SpringApplication.run(Application.class, args);
    }

}
