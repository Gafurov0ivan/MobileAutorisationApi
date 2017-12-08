package com.gafur.mobile.api.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Модель для профиля пользователя
 *
 * @author igafurov
 * @since 07.12.2017
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "UserProfile", description = "User profile information")
public class UserProfileDto {

    @ApiModelProperty(value = "Id", example = "1")
    private Long id;

    @ApiModelProperty(value = "Last name", example = "John", required = true)
    @NonNull
    private String lastName;

    @ApiModelProperty(value = "First name", example = "Doe", required = true)
    @NonNull
    private String firstName;

    @ApiModelProperty(value = "Patronymic", example = "Ivanovich", required = true)
    @NonNull
    private String patronymic;

    @ApiModelProperty(value = "e-mail", example = "address@gmail.com", required = true)
    @NonNull
    @NotEmpty
    private String emailAddress;

    @ApiModelProperty(value = "Link to avatar", example = "https://www.google.ru/intl/myavatar", required = false)
    private String avatarLink;
}
