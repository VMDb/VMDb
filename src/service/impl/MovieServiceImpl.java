package service.impl;

import domain.Genre;
import domain.Movie;
import service.MovieService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieServiceImpl implements MovieService {

    private List<Movie> movies;

    public MovieServiceImpl(){
        this.movies = new ArrayList<>();
    }

    @Override
    public MovieService addMovie(Movie movie) {
        movies.add(movie);
        return this;
    }

    @Override
    public Movie getByID(long id) {
        return movies.stream()
                    .filter(movie -> movie.getId() == id)
                    .findFirst()
                    .orElseGet(null);
    }

    @Override
    public List<Movie> all() {
        return new ArrayList<>(movies);
    }

    @Override
    public List<Movie> getByKeyword(String keyword) {
        return movies.stream()
                     .filter(movie -> (movie.getTitle().contains(keyword) || movie.getPlot().contains(keyword)))
                     .collect(Collectors.toList());
    }

    @Override
    public List<Movie> getByGenre(Genre genre) {
        return movies.stream()
                     .filter(movie -> movie.getGenres().stream().anyMatch(genre1 -> genre1.equals(genre)))
                     .collect(Collectors.toList());
    }
}