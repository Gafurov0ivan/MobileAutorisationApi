package com.gafur.mobile.api.service;

import com.gafur.mobile.api.rest.model.AccountConfirmDto;
import com.gafur.mobile.api.rest.model.AccountLoginDto;
import com.gafur.mobile.api.rest.model.AccountRegistrationDto;
import com.gafur.mobile.api.rest.model.AuthCodeDto;

/**
 * Регистрация и логин
 *
 * @author igafurov
 * @since 07.12.2017
 */
public interface UserAccountService {

    /**
     * Регистрирует пользователя
     *
     * @param account аккаунт
     * @return аккаунт
     */
    AccountRegistrationDto registration(AccountRegistrationDto account);

    /**
     * Подтверждение регистрации
     *
     * @param account
     * @return код авторизации
     */
    AuthCodeDto confirm(AccountConfirmDto account);

    /**
     * Логин пользователя
     *
     * @param account аккаунт
     * @return код авторизации
     */
    AuthCodeDto login(AccountLoginDto account);
}
