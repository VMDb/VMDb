package com.kaufland.vmdb.dto;

import com.kaufland.vmdb.domain.Movie;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class MovieDTO {

    private long id;

    private String title;

    private short releaseYear;

    private short duration;

    private String[] genres;

    private String plot;

    private float rating;

    private String poster;

    public MovieDTO(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.releaseYear = (short) LocalDateTime.ofInstant(movie.getReleaseDate(), ZoneOffset.UTC).getYear();
        this.duration = (short) movie.getDuration();
        this.genres = movie.getGenres().stream().map(e -> e.getName()).toArray(String[]::new);
        this.plot = movie.getPlot();
        this.rating = (float) movie.getRatingCombined() / movie.getRatings();
        this.poster = movie.getPosterUrl();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public short getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(short releaseYear) {
        this.releaseYear = releaseYear;
    }

    public short getDuration() {
        return duration;
    }

    public void setDuration(short duration) {
        this.duration = duration;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
