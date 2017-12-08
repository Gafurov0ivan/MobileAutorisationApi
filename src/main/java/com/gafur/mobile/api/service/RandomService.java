package com.gafur.mobile.api.service;

/**
 * Генерирует код для авторизации по смс
 *
 * @author igafurov
 * @since 07.12.2017
 */
public interface RandomService {

    /**
     * Возвращает валидиные знаки для генерации кода
     *
     * @return набор знаков
     */
    String validCharacters();

    /**
     * генерирует код
     *
     * @return код
     */
    String generateCode();

    /**
     * генерирует код для авторизации
     *
     * @return код
     */
    String generateAuthCode(String phone);

    /**
     * Проставляет нужные знаки
     *
     * @return код
     */
    String customizeCode(String code);
}
