package com.kaufland.vmdb.domain;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
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
