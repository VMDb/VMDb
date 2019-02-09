package com.kaufland.vmdb.request;

import com.kaufland.vmdb.domain.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovieModel {

    private long id;

    private String title;

    private Date releaseDate;

    private int duration;

    private List<String> genres = new ArrayList<>();

    private List<String> writers = new ArrayList<>();

    private List<String> directors = new ArrayList<>();

    private List<String> producers = new ArrayList<>();

    private List<String> actors = new ArrayList<>();

    private String country;

    private List<String> comments = new ArrayList<>();

    private String plot;

    private String posterUrl;

    private double ratingCombined;

    private int ratings;

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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getWriters() {
        return writers;
    }

    public void setWriters(List<String> writers) {
        this.writers = writers;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }

    public List<String> getProducers() {
        return producers;
    }

    public void setProducers(List<String> producers) {
        this.producers = producers;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public double getRatingCombined() {
        return ratingCombined;
    }

    public void setRatingCombined(double ratingCombined) {
        this.ratingCombined = ratingCombined;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public MovieModel(long id, String title, Date releaseDate, int duration, List<String> genres, List<String> writers, List<String> directors, List<String> producers, List<String> actors, String country, List<String> comments, String plot, String posterUrl, double ratingCombined, int ratings) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.genres = genres;
        this.writers = writers;
        this.directors = directors;
        this.producers = producers;
        this.actors = actors;
        this.country = country;
        this.comments = comments;
        this.plot = plot;
        this.posterUrl = posterUrl;
        this.ratingCombined = ratingCombined;
        this.ratings = ratings;
    }

    public MovieModel() {
    }
}
