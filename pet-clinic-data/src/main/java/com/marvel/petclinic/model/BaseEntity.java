package com.marvel.petclinic.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {
    private final Long serialVersionUID = 1L;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
