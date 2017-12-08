package com.gafur.mobile.api.entity.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gafur.mobile.api.entity.IdEntity;
import com.gafur.mobile.api.entity.account.embeddable.AuthStatus;
import com.gafur.mobile.api.entity.account.embeddable.UserProfileEmbeddable;
import com.gafur.mobile.api.rest.model.AccountRegistrationDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Неподтвержденная регистрация
 *
 * @author igafurov
 * @since 07.12.2017
 */
@Entity
@Data
@Table(name = "phone_registration_log",
        uniqueConstraints = @UniqueConstraint(columnNames = {"phone"}, name = "unique_account_phone_number"))
@RequiredArgsConstructor
@NoArgsConstructor
public class PhoneRegistrationLogEntity extends IdEntity {

    @NonNull
    @Column(name = "phone", length = 20, nullable = false)
    private String phone;

    @NonNull
    @Column(name = "password", length = 20, nullable = false)
    private String password;

    @NonNull
    @Column(name = "init_date", nullable = false)
    private Date initDate;

    @JsonIgnore
    @Column(name = "code", length = 20, nullable = false)
    private String code;

    @JsonIgnore
    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "confirm_date")
    private Date confirmDate;

    @Column(name = "sms_id")
    private String smsId;

    @Embedded
    private UserProfileEmbeddable userProfileEmbeddable;


    public PhoneRegistrationLogEntity(AccountRegistrationDto account, Calendar initDate, AuthStatus status) {
        this(account.getPhone(), account.getPassword(), initDate.getTime());
        UserProfileEmbeddable userProfile = new UserProfileEmbeddable();
        userProfile.setLastName(account.getUserProfile().getLastName());
        userProfile.setFirstName(account.getUserProfile().getFirstName());
        userProfile.setPatronymic(account.getUserProfile().getPatronymic());
        userProfile.setEmailAddress(account.getUserProfile().getEmailAddress());
        userProfile.setAvatarLink(account.getUserProfile().getAvatarLink());
        setUserProfileEmbeddable(userProfile);
        setAuthStatus(status);
    }

    public AuthStatus getAuthStatus() {
        return AuthStatus.valueOf(status);
    }

    public void setAuthStatus(AuthStatus st) {
        setStatus(st.getId());
    }

}
