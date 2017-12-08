package com.gafur.mobile.api.service.exception;

import org.springframework.http.HttpStatus;

/**
 * Используется при конфликте данных
 *
 * @author igafurov
 * @since 07.12.2017
 */
public class ConflictException extends HandleException {

    private static final HttpStatus httpStatus = HttpStatus.CONFLICT;

    public ConflictException(String message) {
        super(message, httpStatus);
    }
}
