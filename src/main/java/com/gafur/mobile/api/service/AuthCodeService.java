package com.gafur.mobile.api.service;

import com.gafur.mobile.api.rest.model.AuthCodeDto;

/**
 * Генерирует код авторизации
 *
 * @author Ivan
 * @since 07.12.2017
 */
public interface AuthCodeService {

    /**
     * Генерирует код
     *
     * @param phone телефон
     * @return сгенерированный код
     */
    AuthCodeDto generate(String phone);
}
