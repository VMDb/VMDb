package domain;

import java.time.Instant;
import java.util.List;

public class Movie {

    private long id;
    private String Title;
    private Instant releaseDate;
    private int duration;
    private List<Genre> genres;
    private List<Writer> writers;
    private List<Director> directors;
    private List<Producer> producers;
    private List<Actor> actors;
    private String plot;
    private List<Country> countries;

    public Movie(long id, String title, Instant releaseDate, int duration, List<Genre> genres, List<Writer> writers,
                 List<Director> directors, List<Producer> producers, List<Actor> actors, String plot, List<Country> countries) {
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
}