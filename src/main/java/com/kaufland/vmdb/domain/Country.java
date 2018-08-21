package com.kaufland.vmdb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public Country(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Country() {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
