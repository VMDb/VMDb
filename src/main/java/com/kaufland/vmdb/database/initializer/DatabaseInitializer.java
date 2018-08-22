package com.kaufland.vmdb.database.initializer;

import com.kaufland.vmdb.database.repo.MovieRepository;
import com.kaufland.vmdb.domain.Movie;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Arrays;

@Component
public class DatabaseInitializer implements ApplicationRunner {

    private final MovieRepository movieRepository;

    public DatabaseInitializer(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("heer");

        Movie avengers = new Movie();

        avengers.setTitle("Avengers infinity budget");
        avengers.setDuration(142);
        avengers.setRatingCombined(0.5);
        avengers.setReleaseDate(Instant.now());
        avengers.setPlot("gud movie");

        movieRepository.save(avengers);

        System.out.println(movieRepository.findAllByTitle("Avengers infinity budget"));
    }


}
