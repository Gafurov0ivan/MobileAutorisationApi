package com.gafur.mobile.api.security;

/**
 * Аутентификация пользователя
 *
 * @author Ivan
 * @since 07.12.2017
 */
public interface SecurityService {

    /**
     * Логин пользователя
     *
     * @param phone    номер телефона
     * @param password пароль
     */
    void autologin(String phone, String password);
}
