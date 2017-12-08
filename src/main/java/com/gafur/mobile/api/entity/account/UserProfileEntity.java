package com.gafur.mobile.api.entity.account;

import com.gafur.mobile.api.entity.IdEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/**
 * Профиль пользователя
 *
 * @author igafurov
 * @since 07.12.2017
 */
@Entity
@Table(name = "user_profile")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class UserProfileEntity extends IdEntity {

    @NonNull
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @NonNull
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @NonNull
    @Column(name = "patronymic", length = 50, nullable = false)
    private String patronymic;

    @Column(name = "avatar_link", length = 50, nullable = false)
    private String avatarLink;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account")
    private AccountEntity account;
}
