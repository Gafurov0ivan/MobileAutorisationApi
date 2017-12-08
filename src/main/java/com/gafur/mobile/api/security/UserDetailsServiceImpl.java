package com.gafur.mobile.api.security;

import com.gafur.mobile.api.entity.account.AccountEntity;
import com.gafur.mobile.api.repository.AccountRepository;
import com.gafur.mobile.api.service.exception.NotValidFormException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Получение пользователя из бд
 *
 * @author Ivan
 * @since 07.12.2017
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        AccountEntity account = accountRepository.findByPhone(phone);
        if (account == null) throw new NotValidFormException("You haven't got registered or confirmed yet");
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
        return new org.springframework.security.core.userdetails.User(account.getPhone(), account.getPassword(), grantedAuthorities);
    }

}
