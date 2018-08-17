package domain;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id &&
                rating == comment.rating &&
                Objects.equals(author, comment.author) &&
                Objects.equals(movie, comment.movie) &&
                Objects.equals(content, comment.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, movie, content, rating);
    }
}
