package com.kaufland.vmdb.service.impl;

import com.kaufland.vmdb.database.repo.MovieRepository;
import com.kaufland.vmdb.domain.Genre;
import com.kaufland.vmdb.domain.Movie;
import com.kaufland.vmdb.dto.MovieDTO;
import com.kaufland.vmdb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    private final Random random = new Random();

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
}
