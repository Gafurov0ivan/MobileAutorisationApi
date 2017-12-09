package com.gafur.mobile.api.entity.account;

import com.gafur.mobile.api.entity.IdEntity;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

/**
 * Роли
 *
 * @author igafurov
 * @since 07.12.2017
 */
@Entity
@Table(name = "role")
@NoArgsConstructor
@EqualsAndHashCode
public class RoleEntity extends IdEntity implements GrantedAuthority {

    public RoleEntity(String name) {
        this.name = name;
    }

    @NonNull
    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private Set<AccountEntity> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<AccountEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<AccountEntity> users) {
        this.users = users;
    }

    @Override
    public String getAuthority() {
        return this.name;
    }
}
