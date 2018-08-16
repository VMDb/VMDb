package domain;

public class Comment {

    private long id;
    private Account author;
    private Movie movie;
    private String content;
    private byte rating;

    public Comment(long id, Account author, Movie movie, String content, byte rating) {
        this.id = id;
        this.author = author;
        this.movie = movie;
        this.content = content;
        this.rating = rating;
    }

    public Comment() {
    }

    public long getId() {
        return id;
    }

    public Account getAuthor() {
        return author;
    }

    public byte getRating() {
        return rating;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getContent() {
        return content;
    }
}
