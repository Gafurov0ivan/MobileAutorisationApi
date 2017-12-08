package com.gafur.mobile.api.service;

import com.gafur.mobile.api.entity.account.AccountEntity;
import com.gafur.mobile.api.entity.account.PhoneRegistrationLogEntity;
import com.gafur.mobile.api.rest.model.AccountLoginDto;

/**
 * Операции с пользователем
 *
 * @author igafurov
 * @since 07.12.2017
 */
public interface AccountService {

    /**
     * Сохранение пользователя
     *
     * @param existed аккаунт пользователя
     * @return аккаунт пользователя
     */
    AccountLoginDto save(PhoneRegistrationLogEntity existed);
}
