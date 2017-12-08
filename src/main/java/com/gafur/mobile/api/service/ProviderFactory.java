package com.gafur.mobile.api.service;

import com.gafur.mobile.api.sms.service.SmsService;

/**
 * Фабрика для отправки смс
 *
 * @author igafurov
 * @since 07.12.2017
 */
public interface ProviderFactory {

    /**
     * Возвращает сервис для работы с смс
     *
     * @return сервис
     */
    SmsService get();
}
