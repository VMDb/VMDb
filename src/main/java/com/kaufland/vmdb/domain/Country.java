package com.kaufland.vmdb.domain;

public class Country {
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
