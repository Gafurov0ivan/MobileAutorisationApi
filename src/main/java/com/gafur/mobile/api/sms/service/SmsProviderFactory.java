package com.gafur.mobile.api.sms.service;

import com.gafur.mobile.api.service.ProviderFactory;
import com.gafur.mobile.api.sms.config.TwilioCredentials;
import com.gafur.mobile.api.sms.service.exception.SmsProviderSettingsNotFoundException;
import com.gafur.mobile.api.sms.service.smsprovider.TwilioSmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

/**
 * @author igafurov
 * @since 07.12.2017
 */
@Slf4j
@Service
public class SmsProviderFactory implements ProviderFactory {

    private static SmsService smsService;

    @Autowired
    private TwilioCredentials twilioCfg;

    public SmsService get() {
        if (isNull(smsService)) {
            if (twilioCfg.isValid())
                return TwilioSmsService.of(twilioCfg);
            else
                throw new SmsProviderSettingsNotFoundException();
        }
        return smsService;
    }
}
