package com.kaufland.vmdb.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Permission role;

    private String name;

    public Account(Permission role, String name) {
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

    public void setRole(Permission role) {
        this.role = role;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return id == account.id &&
                Objects.equals(role, account.role) &&
                Objects.equals(name, account.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, name);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", role=" + role +
                ", name='" + name + '\'' +
                '}';
    }
}
