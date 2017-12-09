package com.gafur.mobile.api.services;

import com.gafur.mobile.api.config.app.RandomKeyConfig;
import com.gafur.mobile.api.config.app.TextsConfig;
import com.gafur.mobile.api.help.AppSpringBootTestNG;
import com.gafur.mobile.api.sms.config.TwilioCredentials;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author igafurov
 * @since 07.12.2017
 */
@Slf4j
public class ConfigurationTests extends AppSpringBootTestNG {

    @Autowired
    private RandomKeyConfig randKeyCfg;
    @Autowired
    private TextsConfig smsCfg;
    @Autowired
    private TwilioCredentials twilio;


    @Test
    public void testRandomKeyConfig() throws Exception {
        log.debug("configuration: {}", randKeyCfg);
        assertThat(randKeyCfg.getSize()).isGreaterThan(2);
        assertThat(randKeyCfg.getPartitionSize()).isGreaterThan(0);
        assertThat(randKeyCfg.getDelimiter()).isNotEmpty();
        assertThat(randKeyCfg.getWithLetters()).isIn(true, false);
        assertThat(randKeyCfg.getPartitionSize()).isLessThan(randKeyCfg.getSize());
    }

    @Test
    public void testSmsTestsCfg() throws Exception {
        log.debug("smsCfg: {}", smsCfg);
        assertThat(smsCfg.getVerificationText()).isNotEmpty();
        assertThat(smsCfg.getVerificationText()).contains("#AUTH_CODE#");
        assertThat(smsCfg.getApplicationName()).isNotEmpty();
    }

    @Test
    public void testTwilioCredentials() throws Exception {
        log.debug("twilio: {}", twilio);
        assertThat(twilio.getAccountSid()).isNotEmpty();
        assertThat(twilio.getAuthToken()).isNotEmpty();
        assertThat(twilio.getPhoneNumber()).isNotEmpty();
    }

}
