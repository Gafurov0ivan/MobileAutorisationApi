package com.gafur.mobile.api.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Модель для логина
 *
 * @author igafurov
 * @since 07.12.2017
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "AccountLogin", description = "Login")
public class AccountLoginDto {

    @ApiModelProperty(value = "Phone number", example = "14053264519", required = true)
    @NonNull
    private String phone;

    @ApiModelProperty(value = "Password", example = "Qwert123", required = true)
    @NonNull
    private String password;
}
