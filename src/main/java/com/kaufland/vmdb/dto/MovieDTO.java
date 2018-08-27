package com.kaufland.vmdb.dto;

import com.kaufland.vmdb.domain.Movie;

public class MovieDTO {

    private long id;

    private String title;

    private short releaseYear;

    private short duration;

    private String[] genres;

    private String plot;

    private float rating;

    public MovieDTO(Movie movie) {

    }
}
