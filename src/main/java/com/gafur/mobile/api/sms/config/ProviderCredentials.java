package com.gafur.mobile.api.sms.config;

import lombok.Data;

import java.io.Serializable;

import static java.util.Objects.nonNull;

/**
 * @author igafurov
 * @since 07.12.2017
 */
@Data
public class ProviderCredentials implements Serializable {

    private String authToken;

    public boolean isValid() {
        return nonNull(getAuthToken());
    }
}
