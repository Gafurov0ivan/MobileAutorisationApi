package com.gafur.mobile.api.sms.service.smsprovider;

import com.gafur.mobile.api.rest.model.MessageDto;
import com.gafur.mobile.api.sms.config.TwilioCredentials;
import com.gafur.mobile.api.sms.service.SmsService;
import com.gafur.mobile.api.sms.util.TwilioMessageCreator;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

/**
 * @author igafurov
 * @since 07.12.2017
 */
@Service
@Slf4j
public class TwilioSmsService implements SmsService {

    private TwilioCredentials credentials;
    private TwilioMessageCreator messageCreator;

    private TwilioSmsService(TwilioCredentials credentials) {
        this.credentials = credentials;
    }

    public static TwilioSmsService of(TwilioCredentials credentials) {
        return new TwilioSmsService(credentials);
    }

    public MessageDto sendMessage(String to, String message) {
        return sendMessage(to, message, null);
    }

    public MessageDto sendMessage(String to, String message, String mediaUrl) {
        Message response = messageCreator().create(to, credentials.getPhoneNumber(), message, mediaUrl);
        return MessageDto.of(response);
    }

    private TwilioMessageCreator messageCreator() {
        if (isNull(messageCreator)) {
            return new TwilioMessageCreator(
                    new TwilioRestClient.Builder(
                            credentials.getAccountSid(),
                            credentials.getAuthToken()
                    ).build()
            );
        }
        return messageCreator;
    }
}
