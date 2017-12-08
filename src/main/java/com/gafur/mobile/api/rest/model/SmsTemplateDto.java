package com.gafur.mobile.api.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import static java.util.Objects.nonNull;

/**
 * Модель для отправки смс сообщения
 *
 * @author igafurov
 * @since 07.12.2017
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "SmsTemplate", description = "SMS template")
public class SmsTemplateDto {

    @ApiModelProperty(value = "Application Name", example = "android app")
    private String applicationName;
    @ApiModelProperty(value = "Verification Text", required = true, example = "Your #appName# verification code is #authCode#")
    @NonNull
    private String verificationText;

    public String customVerificationText(String inAuthCode) {
        return customText(verificationText).replaceAll(TemplateNode.authCode.ft(), inAuthCode);
    }

    private String customText(String txt) {
        return nonNull(applicationName) ? txt.replaceAll(TemplateNode.appName.ft(), applicationName) : txt;
    }

    public enum TemplateNode {
        authCode, appName;

        public String ft() {
            return String.format("#%1$s#", name());
        }
    }
}
