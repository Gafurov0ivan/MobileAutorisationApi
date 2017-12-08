package com.gafur.mobile.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Авто генерируемый id для всех entity
 *
 * @author igafurov
 * @since 07.12.2017
 */
@MappedSuperclass
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"id"})
public class IdEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    protected Long id;
}
