package com.tpokora.mailservice.common.model;

import javax.persistence.*;
import javax.persistence.Column;

/**
 * Created by pokor on 24.12.2016.
 */
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    public AbstractEntity() {

    }

    public AbstractEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
