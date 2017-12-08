package com.gafur.mobile.api.sms.service.exception;

import com.gafur.mobile.api.service.exception.HandleException;
import org.springframework.http.HttpStatus;

/**
 * Используется при не найденных настройках смс провайдера
 *
 * @author igafurov
 * @since 07.12.2017
 */
public class SmsProviderSettingsNotFoundException extends HandleException {

    private static final HttpStatus httpStatus = HttpStatus.NOT_FOUND;

    public SmsProviderSettingsNotFoundException() {
        super("Can't find settings for sms provider", httpStatus);
    }
}
