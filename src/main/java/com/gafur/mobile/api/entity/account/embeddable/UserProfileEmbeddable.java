package com.gafur.mobile.api.entity.account.embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;

/**
 * Профиль пользователя для таблицы неподтвержденной регистрации
 *
 * @author igafurov
 * @since 07.12.2017
 */
@Embeddable
@Data
@Table(name = "user_profile",
        uniqueConstraints = @UniqueConstraint(columnNames = {"phone"}, name = "unique_user_phone_number"))
@RequiredArgsConstructor
@NoArgsConstructor
public class UserProfileEmbeddable implements Serializable {

    @NonNull
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @NonNull
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @NonNull
    @Column(name = "patronymic", length = 50, nullable = false)
    private String patronymic;

    @NonNull
    @Column(name = "email_address", length = 50, nullable = false)
    private String emailAddress;

    @Column(name = "avatar_link", length = 50)
    private String avatarLink;

}
