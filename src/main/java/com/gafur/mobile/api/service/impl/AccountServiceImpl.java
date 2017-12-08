package com.gafur.mobile.api.service.impl;

import com.gafur.mobile.api.entity.account.AccountEntity;
import com.gafur.mobile.api.entity.account.PhoneRegistrationLogEntity;
import com.gafur.mobile.api.entity.account.RoleEntity;
import com.gafur.mobile.api.entity.account.UserProfileEntity;
import com.gafur.mobile.api.repository.AccountRepository;
import com.gafur.mobile.api.repository.RoleRepository;
import com.gafur.mobile.api.rest.model.AccountLoginDto;
import com.gafur.mobile.api.service.AccountService;
import com.gafur.mobile.api.service.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author igafurov
 * @since 07.12.2017
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    RandomService randomService;

    @Override
    public AccountLoginDto save(PhoneRegistrationLogEntity source) {
        AccountEntity entity = accountRepository.save(map(source));
        return map(entity);
    }

    private AccountLoginDto map(AccountEntity source) {
        AccountLoginDto target = new AccountLoginDto();
        if (source == null) return target;
        target.setPhone(source.getPhone());
        target.setPassword(source.getPassword());
        return target;
    }

    private AccountEntity map(PhoneRegistrationLogEntity source) {
        if (source == null) return new AccountEntity();
        UserProfileEntity target = new UserProfileEntity();
        target.setFirstName(source.getUserProfileEmbeddable().getFirstName());
        target.setLastName(source.getUserProfileEmbeddable().getLastName());
        target.setPatronymic(source.getUserProfileEmbeddable().getPatronymic());
        target.setAvatarLink(source.getUserProfileEmbeddable().getAvatarLink());
        target.setEmail(source.getUserProfileEmbeddable().getEmailAddress());
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAuthCode(randomService.generateAuthCode(source.getPhone()));
        accountEntity.setPhone(source.getPhone());
        accountEntity.setPassword(passwordEncoder.encode(source.getPassword()));
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(new RoleEntity("ROLE_USER"));
        accountEntity.setRoles(roles);
        target.setAccount(accountEntity);
        accountEntity.setUserProfile(target);
        return accountEntity;
    }

}
