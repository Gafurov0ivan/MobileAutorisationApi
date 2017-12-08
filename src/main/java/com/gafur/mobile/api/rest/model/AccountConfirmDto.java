package com.gafur.mobile.api.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.gafur.mobile.api.util.StringUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * Модель для подтверждения регистрации
 *
 * @author igafurov
 * @since 07.12.2017
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "AccountConfirm", description = "Sample model for confirmation")
public class AccountConfirmDto {

    @ApiModelProperty(value = "Phone number", example = "14053264519", required = true)
    @NonNull
    private String phone;

    @ApiModelProperty(value = "Verification code", example = "CW7T863H", required = true)
    @NonNull
    private String code;

    public String clearConfirmationCode() {
        return StringUtil.clearNonAlphabeticNonDigit(getCode().toLowerCase()).toUpperCase();
    }
}
