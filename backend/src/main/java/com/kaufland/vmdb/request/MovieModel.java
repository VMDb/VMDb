package com.kaufland.vmdb.request;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    //@JsonProperty("genres.name")
    private List<String> genresName = new ArrayList<>();
    //@JsonProperty("writers.name")
    private List<String> writersName = new ArrayList<>();
    //@JsonProperty("directors.name")
    private List<String> directorsName = new ArrayList<>();
    //@JsonProperty("producers.name")
    private List<String> producersName = new ArrayList<>();
    //@JsonProperty("actors.name")
    private List<String> actorsName = new ArrayList<>();
    //@JsonProperty("country.name")
    private String countryName;

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

    public List<String> getGenresName() {
        return genresName;
    }

    public void setGenresName(List<String> genresName) {
        this.genresName = genresName;
    }

    public List<String> getWritersName() {
        return writersName;
    }

    public void setWritersName(List<String> writersName) {
        this.writersName = writersName;
    }

    public List<String> getDirectorsName() {
        return directorsName;
    }

    public void setDirectorsName(List<String> directorsName) {
        this.directorsName = directorsName;
    }

    public List<String> getProducersName() {
        return producersName;
    }

    public void setProducersName(List<String> producersName) {
        this.producersName = producersName;
    }

    public List<String> getActorsName() {
        return actorsName;
    }

    public void setActorsName(List<String> actorsName) {
        this.actorsName = actorsName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
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

    public MovieModel() {
    }
}
