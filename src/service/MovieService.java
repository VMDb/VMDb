package service;

import domain.Genre;
import domain.Movie;

import java.util.List;

public interface MovieService {

    MovieService addMovie(Movie movie);

    Movie getByID(long id);

    List<Movie> all();

    List<Movie> getByKeyword(String keyword);

    List<Movie> getByGenre(Genre genre);

}
