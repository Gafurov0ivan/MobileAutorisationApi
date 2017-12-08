package com.gafur.mobile.api.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Модель для кода авторизации
 *
 * @author igafurov
 * @since 07.12.2017
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "AuthCode", description = "Auth code to access api")
public class AuthCodeDto {

    @ApiModelProperty(value = "Auth Code", example = "DMBW2TXC5456456NLДЫВЫDSFVDDFDFBDFBВÄÖKKМЫВЪЇЄ", required = true)
    private String authCode;
}
