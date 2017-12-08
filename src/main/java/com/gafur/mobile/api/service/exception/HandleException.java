package com.gafur.mobile.api.service.exception;

import org.springframework.http.HttpStatus;

/**
 * Маркер
 *
 * @author igafurov
 * @since 07.12.2017
 */
public class HandleException extends RuntimeException {

    private HttpStatus httpStatus;

    public HandleException(String message, HttpStatus status) {
        super(message);
        this.httpStatus = status;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
