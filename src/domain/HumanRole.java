package domain;

public enum HumanRole {

    WRITER(1),
    DIRECTOR(2),
    PRODUCER(3),
    ACTOR(4);

    private long id;

    HumanRole(long id){
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

}
