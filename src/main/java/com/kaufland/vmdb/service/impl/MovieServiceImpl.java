package com.kaufland.vmdb.service.impl;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.kaufland.vmdb.database.repo.MovieRepository;
import com.kaufland.vmdb.domain.Genre;
import com.kaufland.vmdb.domain.Movie;
import com.kaufland.vmdb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.Year;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Override
    public MovieService addMovie(Movie movie) {
        movieRepository.save(movie);
        return this;
    }

    @Override
    public Movie getByID(long id) {
        return movieRepository.findById(id)
                              .orElse(null);
        
    }

    @Override
    public List<Movie> all() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> getByKeyword(String keyword) {
        return movieRepository.findAllByPlotLike(keyword);
    }

    @Override
    public List<Movie> getByGenre(Genre genre) {
        return movieRepository.findAllByGenresIn(genre);
    }
}
