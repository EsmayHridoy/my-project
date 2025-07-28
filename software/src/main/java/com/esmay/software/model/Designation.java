package com.esmay.software.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "designations")
public class Designation extends NameEntity {

    public Designation() {}

    public Designation(String name) {
        super(name);
    }
}
