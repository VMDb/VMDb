package com.kaufland.vmdb.domain;

public class Permission {

    private long id;
    private String name;

    public Permission(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Permission() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}