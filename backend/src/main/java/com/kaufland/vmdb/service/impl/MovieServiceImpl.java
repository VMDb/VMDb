package com.kaufland.vmdb.service.impl;

import com.kaufland.vmdb.database.repo.MovieRepository;
import com.kaufland.vmdb.domain.*;
import com.kaufland.vmdb.dto.MovieDTO;
import com.kaufland.vmdb.request.MovieModel;
import com.kaufland.vmdb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final CountryService countryService;

    private final ActorService actorService;
    private final WriterService writerService;
    private final DirectorService directorService;
    private final ProducerService producerService;
    private final GenreService genreService;

    private final Random random = new Random();

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, CountryService countryService, ActorService actorService, WriterService writerService, DirectorService directorService, ProducerService producerService, GenreService genreService){
        this.movieRepository = movieRepository;
        this.countryService = countryService;
        this.actorService = actorService;
        this.writerService = writerService;
        this.directorService = directorService;
        this.producerService = producerService;
        this.genreService = genreService;
    }

    @Override
    public MovieService addMovie(MovieModel model) {
        movieRepository.save(toMovie(model, Movie::new));
        return this;
    }

    @Override
    public Movie updateMovie(MovieModel movieModel, Integer movieId) {
        Movie movie = toMovie(movieModel, () -> movieRepository.getOne((long) movieId));
        movieRepository.save(movie);
        return movie;
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
    public Movie toMovie(MovieModel model, Supplier<Movie> movieSupplier){
        Movie movie = movieSupplier.get();
        movie.setCountry(countryService.getCountryFromName(model.getCountryName()));
        movie.setPlot(model.getPlot());
        movie.setTitle(model.getTitle());
        movie.setRatingCombined(model.getRatingCombined());
        movie.setReleaseDate(model.getReleaseDate().toInstant());
        movie.setDuration(model.getDuration());
        movie.setRatings(model.getRatings());
        movie.setPosterUrl(model.getPosterUrl());

        movie.setGenres(genreService.findGenresIn(model.getGenresName()));
        movie.setActors(actorService.findByNameIn(model.getActorsName()));
        movie.setProducers(producerService.findByNameIn(model.getActorsName()));
        movie.setDirectors(directorService.findByNameIn(model.getActorsName()));
        movie.setWriters(writerService.findByNameIn(model.getActorsName()));

        return movie;
    }

}
