package com.kaufland.vmdb.domain;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String Title;

    private Instant releaseDate;

    private int duration;

    @ManyToMany
    private List<Genre> genres;

    @ManyToMany
    private List<Writer> writers;

    @ManyToMany
    private List<Director> directors;

    @ManyToMany
    private List<Producer> producers;

    @ManyToMany
    private List<Actor> actors;

    @ManyToMany
    private List<Country> countries;

    @OneToMany
    private List<Comment> comments;

    private String plot;

    private double ratingCombined;

    private int ratings;

    public Movie(long id, String title, Instant releaseDate, int duration, List<Genre> genres, List<Writer> writers,
                 List<Director> directors, List<Producer> producers, List<Actor> actors, String plot, List<Country> countries, List<Comment> comments) {
        this.id = id;
        Title = title;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.genres = genres;
        this.writers = writers;
        this.directors = directors;
        this.producers = producers;
        this.actors = actors;
        this.plot = plot;
        this.countries = countries;
        this.comments = comments;
        this.ratingCombined = 0.0d;
        this.ratings = 0;
    }

    public Movie() {
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return Title;
    }

    public Instant getReleaseDate() {
        return releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public List<Writer> getWriters() {
        return writers;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public List<Producer> getProducers() {
        return producers;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public String getPlot() {
        return plot;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id &&
                duration == movie.duration &&
                Double.compare(movie.ratingCombined, ratingCombined) == 0 &&
                ratings == movie.ratings &&
                Objects.equals(Title, movie.Title) &&
                Objects.equals(releaseDate, movie.releaseDate) &&
                Objects.equals(genres, movie.genres) &&
                Objects.equals(writers, movie.writers) &&
                Objects.equals(directors, movie.directors) &&
                Objects.equals(producers, movie.producers) &&
                Objects.equals(actors, movie.actors) &&
                Objects.equals(plot, movie.plot) &&
                Objects.equals(countries, movie.countries) &&
                Objects.equals(comments, movie.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Title, releaseDate, duration, genres, writers, directors, producers, actors, plot, countries, comments, ratingCombined, ratings);
    }
}