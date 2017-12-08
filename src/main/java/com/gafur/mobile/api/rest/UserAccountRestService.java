package com.gafur.mobile.api.rest;

import com.gafur.mobile.api.rest.model.AccountConfirmDto;
import com.gafur.mobile.api.rest.model.AccountLoginDto;
import com.gafur.mobile.api.rest.model.AccountRegistrationDto;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Рест сервис для регистрации и логина
 *
 * @author igafurov
 * @since 07.12.2017
 */
@RequestMapping("/v1/account")
public interface UserAccountRestService {

    /**
     * Регистрация пользователя
     *
     * @param account аккаунт пользователя
     * @return аккаунт пользователя
     */
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    ResponseEntity<?> registration(@ApiParam(value = "Account to registration", required = true)
                                   AccountRegistrationDto account);

    /**
     * Подтверждение регистрации
     *
     * @param accountConfirm аккаунт для подтверждения
     * @return код авторизации
     */
    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    ResponseEntity<?> confirm(@ApiParam(value = "Account to confirm verification", required = true)
                              AccountConfirmDto accountConfirm);

    /**
     * Подтверждение регистрации
     *
     * @param accountLogin аккаунт для логина
     * @return код авторизации
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    ResponseEntity<?> login(@ApiParam(value = "Account for login", required = true)
                            AccountLoginDto accountLogin);
}
