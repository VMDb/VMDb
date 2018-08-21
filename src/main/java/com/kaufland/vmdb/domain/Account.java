package com.kaufland.vmdb.domain;

public class Account {

    private long id;
    private Permission role;
    private String name;

    public Account(long id, Permission role, String name) {
        this.id = id;
        this.role = role;
        this.name = name;
    }

    public Account() {
    }

    public Permission getRole() {
        return role;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
