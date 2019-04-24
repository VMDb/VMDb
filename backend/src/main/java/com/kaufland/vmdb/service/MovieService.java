package com.kaufland.vmdb.service;

import com.kaufland.vmdb.domain.Genre;
import com.kaufland.vmdb.domain.Movie;
import com.kaufland.vmdb.dto.MovieDTO;
import com.kaufland.vmdb.request.MovieModel;

import java.util.List;
import java.util.function.Supplier;

public interface MovieService {

    Movie toMovie(MovieModel model, Supplier<Movie> movieSupplier);

    MovieService addMovie(Movie movie);

    Movie updateMovie(Movie movie);

    Movie getByID(long id);

    List<MovieDTO> allInTheaters();

    List<Movie> getByKeyword(String keyword);

    List<Movie> getByGenre(Genre genre);

}
