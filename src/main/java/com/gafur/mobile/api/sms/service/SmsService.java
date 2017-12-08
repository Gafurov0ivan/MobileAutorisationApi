package com.gafur.mobile.api.sms.service;

import com.gafur.mobile.api.rest.model.MessageDto;

/**
 * Отправка смс
 *
 * @author igafurov
 * @since 07.12.2017
 */
public interface SmsService {

    /**
     * Отправка смс
     *
     * @param to      получатель
     * @param message сообщение
     * @return сообщение
     */
    MessageDto sendMessage(String to, String message);

}
