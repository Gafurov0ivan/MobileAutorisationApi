package com.gafur.mobile.api.service.exception;

import org.springframework.http.HttpStatus;

/**
 * Используется при не валидных данных
 *
 * @author igafurov
 * @since 07.12.2017
 */
public class NotValidFormException extends HandleException {

    private static final HttpStatus httpStatus = HttpStatus.NOT_ACCEPTABLE;

    public NotValidFormException(String message) {
        super(message, httpStatus);
    }
}
