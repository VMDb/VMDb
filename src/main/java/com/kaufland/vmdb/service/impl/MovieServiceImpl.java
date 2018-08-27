package com.kaufland.vmdb.service.impl;

import com.kaufland.vmdb.database.repo.MovieRepository;
import com.kaufland.vmdb.domain.Genre;
import com.kaufland.vmdb.domain.Movie;
import com.kaufland.vmdb.dto.MovieDTO;
import com.kaufland.vmdb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
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
    public List<MovieDTO> all() {
        List<Movie> movies = movieRepository.findAll();
        movies.forEach(m -> m.getActors().size());

        return movies.stream().map(e -> new MovieDTO(e)).collect(Collectors.toList());

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
