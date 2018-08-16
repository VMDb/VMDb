package domain;

public class Genre {

    private long id;
    private String name;

    public Genre(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Genre() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
