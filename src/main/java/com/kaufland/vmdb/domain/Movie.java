package com.kaufland.vmdb.domain;

import com.kaufland.vmdb.database.initializer.DatabaseInitializer;
import org.hibernate.Hibernate;
import org.json.JSONObject;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String title;

    private Instant releaseDate;

    private int duration;

    @ManyToMany
    private List<Genre> genres = new ArrayList<>();

    @ManyToMany
    private List<Writer> writers = new ArrayList<>();

    @ManyToMany
    private List<Director> directors = new ArrayList<>();

    @ManyToMany
    private List<Producer> producers = new ArrayList<>();

    @ManyToMany
    private List<Actor> actors = new ArrayList<>();

    @ManyToOne
    private Country country;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    private String plot;

    private double ratingCombined;

    private int ratings;

    public Movie(String title, Instant releaseDate, int duration, List<Genre> genres, List<Writer> writers,
                 List<Director> directors, List<Producer> producers, List<Actor> actors, String plot, Country country, List<Comment> comments) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.genres = genres;
        this.writers = writers;
        this.directors = directors;
        this.producers = producers;
        this.actors = actors;
        this.plot = plot;
        this.country = country;
        this.comments = comments;
        this.ratingCombined = 0.0d;
        this.ratings = 0;


    }

    public Movie() {
    }

    public static Movie fromJSON(JSONObject object){
        Movie movie = new Movie();
        movie.title = object.getString("Title");
        try {
            movie.releaseDate = new SimpleDateFormat("dd MMM yyyy").parse(object.getString("Released")).toInstant();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        movie.duration = Integer.parseInt(object.getString("Runtime").split("\\s")[0]);
        System.out.println(DatabaseInitializer.getInstance().getGenreRepository().findAllByName("Comedy")) ;
        movie.genres.forEach(System.out::println);


        return movie;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseDate(Instant releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public void setWriters(List<Writer> writers) {
        this.writers = writers;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public void setProducers(List<Producer> producers) {
        this.producers = producers;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public void setRatingCombined(double ratingCombined) {
        this.ratingCombined = ratingCombined;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
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

    public Country getCountry() {
        return country;
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
                Objects.equals(title, movie.title) &&
                Objects.equals(releaseDate, movie.releaseDate) &&
                Objects.equals(genres, movie.genres) &&
                Objects.equals(writers, movie.writers) &&
                Objects.equals(directors, movie.directors) &&
                Objects.equals(producers, movie.producers) &&
                Objects.equals(actors, movie.actors) &&
                Objects.equals(plot, movie.plot) &&
                Objects.equals(country, movie.country) &&
                Objects.equals(comments, movie.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, releaseDate, duration, genres, writers, directors, producers, actors, plot, country, comments, ratingCombined, ratings);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration +
                ", genres=" + genres +
                ", writers=" + writers +
                ", directors=" + directors +
                ", producers=" + producers +
                ", actors=" + actors +
                ", country=" + country +
                ", comments=" + comments +
                ", plot='" + plot + '\'' +
                ", ratingCombined=" + ratingCombined +
                ", ratings=" + ratings +
                '}';
    }
}