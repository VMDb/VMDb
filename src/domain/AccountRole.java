package domain;

public enum AccountRole {

    USER(1),
    ADMIN(2);

    private long id;

    AccountRole(long id){
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

}