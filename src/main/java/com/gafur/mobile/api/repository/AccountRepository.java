package com.gafur.mobile.api.repository;

import com.gafur.mobile.api.entity.account.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * DAO для пользователя
 *
 * @author igafurov
 * @since 05.12.2017
 */
@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    /**
     * Возвращает пользователя по номеру телефона
     *
     * @param phone телефон
     * @return пользователь
     */
    AccountEntity findByPhone(String phone);
}
