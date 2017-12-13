package com.gafur.mobile.api.entity.account;

import com.gafur.mobile.api.entity.IdEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * Пользователь
 *
 * @author igafurov
 * @since 05.12.2017
 */
@Entity
@Data
@Table(name = "account",
       uniqueConstraints = @UniqueConstraint(columnNames = {"phone"},
       name = "unique_user_phone_number"))
@RequiredArgsConstructor
@NoArgsConstructor
public class AccountEntity extends IdEntity {

    @NonNull
    @Column(name = "phone", length = 20, nullable = false)
    private String phone;

    @NonNull
    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Transient
    private String passwordConfirm;

    @NonNull
    @Column(name = "auth_code", length = 250, nullable = false)
    private String authCode;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "account_role", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "account", cascade = CascadeType.ALL)
    private UserProfileEntity userProfile;
}
