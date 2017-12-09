package com.gafur.mobile.api.service.validation;

import com.gafur.mobile.api.entity.account.PhoneRegistrationLogEntity;
import com.gafur.mobile.api.rest.model.AccountConfirmDto;
import com.gafur.mobile.api.rest.model.AccountLoginDto;
import com.gafur.mobile.api.rest.model.AccountRegistrationDto;
import com.gafur.mobile.api.service.exception.NotValidFormException;

/**
 * Валидация для регистрации и логина
 *
 * @author igafurov
 * @since 07.12.2017
 */
public interface UserAccountValidator {

    /**
     * Проверяет валидность аккаунта пользователя при регистрации
     *
     * @param account аккаунт
     */
    void isValidRegistrationForm(AccountRegistrationDto account);

    /**
     * Проверяет валидность аккаунта пользователя при логине
     *
     * @param account аккаунт
     */
    void isValidLoginForm(AccountLoginDto account);

    /**
     * Проверяет валидность подтверждения регистрации
     *
     * @param external форма подтверждения
     * @param existed  информация по регистрации из бд
     */
    void isValidConfirmForm(AccountConfirmDto external, PhoneRegistrationLogEntity existed);
}
