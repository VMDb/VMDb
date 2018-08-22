package com.kaufland.vmdb.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Account author;

    @ManyToOne
    private Movie movie;

    private String content;

    private byte rating;


    public Comment(Account author, Movie movie, String content, byte rating) {
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

    public void setAuthor(Account author) {
        this.author = author;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRating(byte rating) {
        this.rating = rating;
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

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", author=" + author +
                ", movie=" + movie +
                ", content='" + content + '\'' +
                ", rating=" + rating +
                '}';
    }
}
