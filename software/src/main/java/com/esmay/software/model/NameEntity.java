package com.esmay.software.model;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotEmpty;

@MappedSuperclass
public class NameEntity extends BaseEntity {

    @Column(name = "name", nullable = false)
    @NotEmpty(message = "Name is required")
    private String name;

    public NameEntity() {}

    public NameEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

