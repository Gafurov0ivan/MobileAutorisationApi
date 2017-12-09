package com.gafur.mobile.api.service.impl;

import com.gafur.mobile.api.config.app.TextsConfig;
import com.gafur.mobile.api.entity.account.PhoneRegistrationLogEntity;
import com.gafur.mobile.api.entity.account.embeddable.AuthStatus;
import com.gafur.mobile.api.repository.PhoneRegistrationLogRepository;
import com.gafur.mobile.api.rest.model.*;
import com.gafur.mobile.api.security.SecurityService;
import com.gafur.mobile.api.service.*;
import com.gafur.mobile.api.service.exception.ConflictException;
import com.gafur.mobile.api.service.exception.SmsNotDeliveredException;
import com.gafur.mobile.api.service.validation.UserAccountValidatorImpl;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;


/**
 * @author igafurov
 * @since 07.12.2017
 */
@Service
@Getter
@Accessors(fluent = true)
@Slf4j
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private ProviderFactory smsProvider;
    @Autowired
    private RandomService randService;
    @Autowired
    private PhoneRegistrationLogRepository phoneRegistrationLogRepository;
    @Autowired
    private UserProfileService userProfileService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private TextsConfig txt;
    @Autowired
    private UserAccountValidatorImpl userValidator;
    @Autowired
    private AuthCodeService authCodeService;
    @Autowired
    private SecurityService securityService;

    public AccountRegistrationDto registration(AccountRegistrationDto account) {
        userValidator.isValidRegistrationForm(account);

        PhoneRegistrationLogEntity existed = findByPhone(account.getPhone());

        if (nonNull(existed)) {
            throw new ConflictException("AccountEntity with phone " + account.getPhone() + " already registered");
        }

        PhoneRegistrationLogEntity entityToSave = new PhoneRegistrationLogEntity(account,
                Calendar.getInstance(),
                AuthStatus.WAIT);
        entityToSave.setCode(sendSms(account, entityToSave));
        return map(phoneRegistrationLogRepository.save(entityToSave));
    }


    public AuthCodeDto confirm(AccountConfirmDto external) {
        PhoneRegistrationLogEntity existed = findByPhone(external.getPhone());
        userValidator.isValidConfirmForm(external, existed);
        accountService.save(existed);
        existed.setAuthStatus(AuthStatus.CONFIRMED);
        existed.setConfirmDate(Calendar.getInstance().getTime());
        phoneRegistrationLogRepository.save(existed);
        return authCodeService.generate(existed.getPhone());
    }

    @Override
    public AuthCodeDto login(AccountLoginDto external) {
        userValidator.isValidLoginForm(external);
        securityService.autologin(external.getPhone(), external.getPassword());
        return authCodeService.generate(external.getPhone());
    }

    protected PhoneRegistrationLogEntity findByPhone(String phone) {
        return phoneRegistrationLogRepository.findByPhone(phone);
    }

    private String sendSms(AccountRegistrationDto account, PhoneRegistrationLogEntity entityToSave) {
        String secureCode = randService.generateCode();
        String message = compileMessageText(account.getTemplate(), secureCode);
        MessageDto m = smsProvider.get().sendMessage(account.getPhone(), message);
        entityToSave.setSmsId(m.getMessageID());
        if (!m.isMessageQueued()) {
            entityToSave.setAuthStatus(AuthStatus.SMS_NOT_DELIVERED);
            throw new SmsNotDeliveredException(account.getPhone());
        }
        return secureCode;
    }

    private AccountRegistrationDto map(PhoneRegistrationLogEntity source) {
        AccountRegistrationDto target = new AccountRegistrationDto();
        if (source == null) return target;
        target.setPhone(source.getPhone());
        target.setUserProfile(userProfileService.map(source.getUserProfileEmbeddable()));
        return target;
    }

    protected String compileMessageText(SmsTemplateDto templ, String secureCode) {
        if (isNull(templ) || isNull(templ.getVerificationText()) || templ.getVerificationText().isEmpty()) {
            templ = txt();
        }
        return templ.customVerificationText(randService().customizeCode(secureCode));
    }

}
