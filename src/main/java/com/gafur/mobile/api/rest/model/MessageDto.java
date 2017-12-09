package com.gafur.mobile.api.rest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.twilio.rest.api.v2010.account.Message;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import static java.util.Objects.nonNull;

/**
 * Модель для смс сообщений
 *
 * @author igafurov
 * @since 07.12.2017
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Slf4j
@ApiModel(value = "ExceptionDto", description = "Exception Response `success = false`")
public class MessageDto {

    Message twilio;
    String messageID;
    String messageStatus;
    String messageStatusDescription;

    private MessageDto(Message fromTwilio) {
        this.twilio = fromTwilio;
        messageID = twilio.getSid();
        messageStatus = twilio.getStatus().name();
        messageStatusDescription = twilio.getStatus().toString();
    }

    public static MessageDto of(Message twilio) {
        return new MessageDto(twilio);
    }

    public String getMessageID() {
        return messageID;
    }

    public boolean isMessageQueued() {
        return nonNull(twilio) && twilio.getStatus().equals(Message.Status.QUEUED);
    }
}
