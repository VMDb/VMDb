package com.kaufland.vmdb.service.impl;

import com.kaufland.vmdb.database.repo.MovieRepository;
import com.kaufland.vmdb.domain.*;
import com.kaufland.vmdb.dto.MovieDTO;
import com.kaufland.vmdb.request.MovieModel;
import com.kaufland.vmdb.service.MovieInsertionService;
import com.kaufland.vmdb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    private final MovieInsertionService movieInsertionService;

    private final Random random = new Random();

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, MovieInsertionService movieInsertionService){
        this.movieRepository = movieRepository;
        this.movieInsertionService = movieInsertionService;
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
    public List<MovieDTO> allInTheaters() {
        long count = movieRepository.count();
        int start = random.nextInt((int) count / 24);
        Pageable limit = PageRequest.of(start, 24);
        Page<Movie> movies = movieRepository.findAll(limit);

        return movies.stream().map(MovieDTO::new).collect(Collectors.toList());

    }

    @Override
    public List<Movie> getByKeyword(String keyword) {
        return movieRepository.findAllByPlotLike(keyword);
    }

    @Override
    public List<Movie> getByGenre(Genre genre) {
        return movieRepository.findAllByGenresIn(genre);
    }

    //TODO
    @Override
    public Movie toMovie(MovieModel model){
        Movie movie = new Movie();
        movie.setReleaseDate(model.getReleaseDate().toInstant());
        movie.setPlot(model.getPlot());
        movie.setDuration(model.getDuration());
        movie.setRatingCombined(model.getRatingCombined());
        movie.setTitle(model.getTitle());
        movie.setCountry  (movieInsertionService.findCountryByName(model.getCountry()));
        movie.setActors   (movieInsertionService.findCrewOfTypeAndNames(Actor.class, model.getActors()));
        movie.setProducers(movieInsertionService.findCrewOfTypeAndNames(Producer.class, model.getProducers()));
        movie.setDirectors(movieInsertionService.findCrewOfTypeAndNames(Director.class, model.getDirectors()));
        movie.setWriters  (movieInsertionService.findCrewOfTypeAndNames(Writer.class, model.getWriters()));
        movie.setGenres   (movieInsertionService.findGenresByNames(model.getGenres()));
        return movie;
    }

}
