package com.gafur.mobile.api.service.impl;

import com.gafur.mobile.api.rest.model.AuthCodeDto;
import com.gafur.mobile.api.security.TokenService;
import com.gafur.mobile.api.service.AuthCodeService;
import com.gafur.mobile.api.service.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ivan
 * @since 07.12.2017
 */
@Service
public class AuthCodeServiceImpl implements AuthCodeService {

    @Autowired
    TokenService tokenService;

    @Override
    public AuthCodeDto generate(String phone) {
        AuthCodeDto authCode = new AuthCodeDto();
        authCode.setAuthCode(tokenService.generateToken(phone));
        return authCode;
    }
}
