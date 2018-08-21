package com.kaufland.vmdb.service;

import com.kaufland.vmdb.domain.Genre;
import com.kaufland.vmdb.domain.Movie;

import java.util.List;

public interface MovieService {

    MovieService addMovie(Movie movie);

    Movie getByID(long id);

    List<Movie> all();

    List<Movie> getByKeyword(String keyword);

    List<Movie> getByGenre(Genre genre);

}
