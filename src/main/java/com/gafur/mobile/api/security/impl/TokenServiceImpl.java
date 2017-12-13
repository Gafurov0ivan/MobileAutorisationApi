package com.gafur.mobile.api.security.impl;

import com.gafur.mobile.api.security.TokenService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ivan
 * @since 12.12.2017
 */
@Component
public class TokenServiceImpl implements TokenService {

    private final String SECRET = "secret_value#@$";
    private final Long EXPIRATION_TIME = 604800L;

    @Override
    public String generateToken(String phone) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", phone);
        claims.put("audience", "WEB");
        claims.put("created", this.getCurrentDate());
        return generateTokenFromClaims(claims);
    }

    private String generateTokenFromClaims(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(this.getExpirationDate())
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    private Date getExpirationDate() {
        return new Date(System.currentTimeMillis() + EXPIRATION_TIME * 1000);
    }

    private Date getCurrentDate() {
        return new Date(System.currentTimeMillis());
    }
}
