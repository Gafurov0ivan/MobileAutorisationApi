package com.gafur.mobile.api.service.exception;

import org.springframework.http.HttpStatus;

/**
 * Используется при не доставленном смс
 *
 * @author igafurov
 * @since 07.12.2017
 */
public class SmsNotDeliveredException extends HandleException {

    private static final HttpStatus httpStatus = HttpStatus.EXPECTATION_FAILED;

    public SmsNotDeliveredException(String phone) {
        super(String.format("Sms with auth code from phone number %1$s not delivered", phone), httpStatus);
    }
}
