package com.gafur.mobile.api.repository;

import com.gafur.mobile.api.entity.account.PhoneRegistrationLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * DAO для неподтвержденной регистрации
 *
 * @author igafurov
 * @since 07.12.2017
 */
@Repository
public interface PhoneRegistrationLogRepository extends JpaRepository<PhoneRegistrationLogEntity, Long> {

    /**
     * Возвращает сущность по номеру телефона
     *
     * @param phone телефон
     * @return сущность
     */
    PhoneRegistrationLogEntity findByPhone(String phone);
}
