package com.gafur.mobile.api.security;

/**
 * Генерация токена
 *
 * @author Ivan
 * @since 12.12.2017
 */
public interface TokenService {

    /**
     * Генерирует токен
     *
     * @param phone
     * @return сгенерированный токен
     */
    String generateToken(String phone);
}
