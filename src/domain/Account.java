package domain;

public class Account {

    private long id;
    private AccountRole role;
    private String name;

    public Account(long id, AccountRole role, String name) {
        this.id = id;
        this.role = role;
        this.name = name;
    }

    public Account() {
    }

    public AccountRole getRole() {
        return role;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
