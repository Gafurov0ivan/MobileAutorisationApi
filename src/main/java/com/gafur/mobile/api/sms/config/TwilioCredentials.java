package com.gafur.mobile.api.sms.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import static java.util.Objects.nonNull;

/**
 * @author igafurov
 * @since 07.12.2017
 */
@Configuration
@ConfigurationProperties
@PropertySource(value = "classpath:application-sms-twilio.properties")
@Data
public class TwilioCredentials extends ProviderCredentials {
    private String accountSid;
    private String phoneNumber;

    public boolean isValid() {
        return super.isValid() && nonNull(getPhoneNumber()) && nonNull(getAccountSid());
    }
}
