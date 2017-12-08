package com.gafur.mobile.api.repository;

import com.gafur.mobile.api.entity.account.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * DAO для работы с профилем пользователя
 *
 * @author igafurov
 * @since 07.12.2017
 */
@Repository
public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Long> {

    /**
     * Возвращает профиль пользователя по номеру телефона
     *
     * @param phone телефон
     * @return профиль пользователя
     */
    @Query("select u from UserProfileEntity u left join u.account a where a.phone = :phone")
    UserProfileEntity findByAccountPhone(@Param("phone") String phone);
}
