package com.gafur.mobile.api.rest.impl;

import com.gafur.mobile.api.rest.UserAccountRestService;
import com.gafur.mobile.api.rest.model.AccountConfirmDto;
import com.gafur.mobile.api.rest.model.AccountLoginDto;
import com.gafur.mobile.api.rest.model.AccountRegistrationDto;
import com.gafur.mobile.api.rest.model.AuthCodeDto;
import com.gafur.mobile.api.service.UserAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author igafurov
 * @since 07.12.2017
 */
@RestController
@Slf4j
public class UserAccountRestServiceImpl implements UserAccountRestService {

    @Autowired
    private UserAccountService userAccountService;

    public ResponseEntity<AccountRegistrationDto> registration(@RequestBody @Valid AccountRegistrationDto account) {
        AccountRegistrationDto registered = userAccountService.registration(account);
        return ResponseEntity.ok().body(registered);
    }

    public ResponseEntity<AuthCodeDto> confirm(@RequestBody @Valid AccountConfirmDto account) {
        AuthCodeDto authCode = userAccountService.confirm(account);
        return ResponseEntity.ok().body(authCode);
    }

    @Override
    public ResponseEntity<AuthCodeDto> login(@RequestBody @Valid AccountLoginDto account) {
        AuthCodeDto authCode = userAccountService.login(account);
        return ResponseEntity.ok().body(authCode);
    }
}
