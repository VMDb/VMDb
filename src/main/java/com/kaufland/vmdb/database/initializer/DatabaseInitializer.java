package com.kaufland.vmdb.database.initializer;

import com.kaufland.vmdb.database.repo.CountryRepository;
import com.kaufland.vmdb.database.repo.GenreRepository;
import com.kaufland.vmdb.database.repo.MovieRepository;
import com.kaufland.vmdb.database.repo.PermissionRepository;
import com.kaufland.vmdb.domain.Country;
import com.kaufland.vmdb.domain.Genre;
import com.kaufland.vmdb.domain.Movie;
import com.kaufland.vmdb.domain.Permission;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DatabaseInitializer implements ApplicationRunner {

    private final MovieRepository movieRepository;

    private final GenreRepository genreRepository;

    private final CountryRepository countryRepository;

    private final PermissionRepository permissionRepository;

    public DatabaseInitializer(MovieRepository movieRepository, GenreRepository genreRepository, CountryRepository countryRepository, PermissionRepository permissionRepository){
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
        this.countryRepository = countryRepository;
        this.permissionRepository = permissionRepository;
    }

    private void saveGenres(){
        Genre action = new Genre();
        action.setName("Action");
        Genre comedy = new Genre();
        comedy.setName("Comedy");
        Genre scifi = new Genre();
        scifi.setName("Sci-Fi");
        Genre adventure = new Genre();
        adventure.setName("Adventure");
        Genre crime = new Genre();
        crime.setName("Crime");
        Genre drama = new Genre();
        drama.setName("Drama");
        Genre fantasy = new Genre();
        fantasy.setName("Fantasy");
        Genre historical = new Genre();
        historical.setName("Historical");
        Genre horror = new Genre();
        horror.setName("Horror");
        Genre mystery = new Genre();
        mystery.setName("Mystery");
        Genre thriller = new Genre();
        thriller.setName("Thriller");
        Genre western = new Genre();
        western.setName("Western");
        Genre animation = new Genre();
        animation.setName("Animation");

        List<Genre> genres = Arrays.asList(action, comedy, scifi,adventure,crime,drama
                ,fantasy,historical,horror,mystery,thriller,western,animation);
        genreRepository.saveAll(genres);
    }

    private void saveCountries(){
        Country us = new Country();
        us.setName("United States");
        Country india = new Country();
        india.setName("India");

        Country bulgaria = new Country();
        bulgaria.setName("Bulgaria");

        Country uk = new Country();
        uk.setName("UK");

        countryRepository.saveAll(Arrays.asList(us, uk, india, bulgaria));
    }

    private void savePermissions(){
        Permission admin = new Permission();
        admin.setName("Admin");
        Permission user = new Permission();
        user.setName("User");

        permissionRepository.saveAll(Arrays.asList(admin, user));
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        saveCountries();
        saveGenres();
        savePermissions();
    }

}
