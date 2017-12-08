package com.gafur.mobile.api.repository;

import com.gafur.mobile.api.entity.account.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DAO для работы с ролями
 *
 * @author igafurov
 * @since 07.12.2017
 */
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
