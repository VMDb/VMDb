package com.kaufland.vmdb.database.initializer;

import com.kaufland.vmdb.access.OmdbAccess;
import com.kaufland.vmdb.database.repo.*;
import com.kaufland.vmdb.domain.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
@Transactional
public class DatabaseInitializer implements ApplicationRunner {

    private final MovieRepository movieRepository;

    private final GenreRepository genreRepository;

    private final CountryRepository countryRepository;

    private final ActorRepository actorRepository;

    private final ProducerRepository producerRepository;

    private final WriterRepository writerRepository;

    private final DirectorRepository directorRepository;

    private final PermissionRepository permissionRepository;

    private final AccountRepository accountRepository;

    private final CommentRepository commentRepository;

    private static DatabaseInitializer instance;

    @Autowired
    public DatabaseInitializer(MovieRepository movieRepository, GenreRepository genreRepository, CountryRepository countryRepository,
                               ActorRepository actorRepository, PermissionRepository permissionRepository, AccountRepository accountRepository,
                               ProducerRepository producerRepository, WriterRepository writerRepository, DirectorRepository directorRepository,
                               CommentRepository commentRepository){
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
        this.countryRepository = countryRepository;
        this.permissionRepository = permissionRepository;
        this.accountRepository = accountRepository;
        this.actorRepository = actorRepository;
        this.directorRepository = directorRepository;
        this.writerRepository = writerRepository;
        this.producerRepository = producerRepository;
        this.commentRepository = commentRepository;
        instance = this;
    }

    public static DatabaseInitializer getInstance() {
        return instance;
    }

    public GenreRepository getGenreRepository() {
        return genreRepository;
    }

    private void testtest(){

        //Movie m = Movie.fromJSON(OmdbAccess.queryMovieByTitle("What's your number"));
    }

    private Instant getRandomDate(int seed){
        return Instant.ofEpochSecond((System.currentTimeMillis() / 1000) - (new Random().nextInt(seed) + 1) * (3600 * 24 * 365));
    }

    private Country getRandomCountry(){
        return countryRepository.getOne((long) new Random().nextInt(4) + 1);
    }

    private void setCountriesIDK(){
        actorRepository.findAll().forEach(actor -> {
            actor.setCareerStart(getRandomDate(40));
            actor.setDateOfBirth(getRandomDate(80));
            actor.setCountry(getRandomCountry());
            actorRepository.save(actor);
        });
        directorRepository.findAll().forEach(actor -> {
            actor.setCareerStart(getRandomDate(40));
            actor.setDateOfBirth(getRandomDate(80));
            actor.setCountry(getRandomCountry());
            directorRepository.save(actor);
        });
        writerRepository.findAll().forEach(actor -> {
            actor.setCareerStart(getRandomDate(40));
            actor.setDateOfBirth(getRandomDate(80));
            actor.setCountry(getRandomCountry());
            writerRepository.save(actor);
        });
        producerRepository.findAll().forEach(actor -> {
            actor.setCareerStart(getRandomDate(40));
            actor.setDateOfBirth(getRandomDate(80));
            actor.setCountry(getRandomCountry());
            producerRepository.save(actor);
        });
    }


    private void trySaveMovieIDK(){

        OmdbAccess.movieIds.stream().forEach(id -> {
            JSONObject object = OmdbAccess.queryMovieById(id);
            System.out.println("Saving movie :: "+object.getString("Title"));
            Movie movie = new Movie();
            movie.setTitle(object.getString("Title"));
            try {
                movie.setReleaseDate(new SimpleDateFormat("dd MMM yyyy").parse(object.getString("Released")).toInstant());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            movie.setGenres(Arrays.asList(object.getString("Genre").split(","))
                    .stream()
                    .map(str -> str.trim())
                    .map(str -> genreRepository.findByName(str))
                    .collect(Collectors.toList()));
            movie.setWriters(Arrays.asList(object.getString("Writer").split(",")).stream()
                    .map(str -> str.replaceAll("\\([\\w\\s]+\\)", "").trim())
                    .map(str -> writerRepository.save(getByName(str, Writer.class, writerRepository)))
                    .collect(Collectors.toList()));
            movie.setActors(Arrays.asList(object.getString("Actors").split(","))
                    .stream()
                    .map(str -> str.trim())
                    .map(str -> actorRepository.save(getByName(str, Actor.class, actorRepository)))
                    .collect(Collectors.toList()));
            movie.setDirectors(Arrays.asList(object.getString("Director").split(","))
                    .stream()
                    .map(str -> str.trim())
                    .map(str -> directorRepository.save(getByName(str, Director.class, directorRepository)))
                    .collect(Collectors.toList()));

            movie.setPosterUrl(object.getString("Poster"));
            if(Integer.parseInt(""+id.charAt(id.length() - 1)) % 2 == 0)
                movie.setProducers(Arrays.asList(producerRepository.findById((long) 2).get()));
            else
                movie.setProducers(Arrays.asList(producerRepository.findById((long) 1).get()));

            movie.setCountry(countryRepository.save(getByName(object.getString("Country").split(",")[0], Country.class, countryRepository)));
            movie.setPlot(object.getString("Plot"));
            movie.setComments(null);
            movie.setDuration(Integer.parseInt(object.getString("Runtime").split("\\s")[0]));

            System.out.println(movieRepository.save(movie));
        });

    }

    private <T extends NameSettable> T getByName(String name, Class<T> clazz, NameSearchableRepository<T> repo){
        T result = repo.findByName(name);
        if(result != null)
            return result;
        try {
            result = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        result.setName(name);
        return result;
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

    private void saveComments(){

    }


    private void saveAccounts(){
        Account a1 = new Account();
        a1.setName("Pesho");
        a1.setRole(permissionRepository.findById((long) 1).get());
        Account a2 = new Account();
        a2.setName("Viki");
        a2.setRole(permissionRepository.findById((long) 2).get());

        accountRepository.saveAll(Arrays.asList(a1, a2));
    }

    private void saveMovies(){
        Movie avengers = new Movie();
        avengers.setTitle("Avengers");
        avengers.setPlot("Film");
        avengers.setReleaseDate(Instant.ofEpochSecond((System.currentTimeMillis() / 1000) - 3600 * 24 * 100));
        avengers.setRatingCombined(1000);
        avengers.setRatings(1000);
        avengers.setGenres(Arrays.asList(genreRepository.findById((long) 1).get(), genreRepository.findById((long) 5).get()));
        avengers.setActors(actorRepository.findAll());
        avengers.setWriters(writerRepository.findAll());
        avengers.setProducers(producerRepository.findAll());
        avengers.setDirectors(directorRepository.findAll());
        avengers.setDuration(114);
        avengers.setComments(null);
        movieRepository.save(avengers);
        System.out.println(movieRepository.findAllByGenresIn(genreRepository.findAllByName("Action").get(0),
                                                             genreRepository.findAllByName("Crime").get(0)));
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        actorRepository.findAll()
                       .forEach(System.out::println);
    }

    private void saveMoviePeople() {
        Actor actor = new Actor("az", countryRepository.findById((long) 3).orElse(null), Instant.now(), Instant.ofEpochMilli(System.currentTimeMillis() - 10000000));
        Actor tomcruise = new Actor("Tommyto", countryRepository.findById((long) 4).orElse(null), Instant.now(), Instant.ofEpochMilli(System.currentTimeMillis() - 10000000));



        actorRepository.save(actor);
        actorRepository.save(tomcruise);

        Director d1 = new Director("az", countryRepository.findById((long) 3).orElse(null), Instant.now(), Instant.ofEpochMilli(System.currentTimeMillis() - 10000000));
        Director d11 = new Director("Tommyto", countryRepository.findById((long) 4).orElse(null), Instant.now(), Instant.ofEpochMilli(System.currentTimeMillis() - 10000000));



        directorRepository.save(d1);
        directorRepository.save(d11);


        Producer p1 = new Producer("VladkoSlatko", countryRepository.findById((long) 3).orElse(null), Instant.now(), Instant.ofEpochMilli(System.currentTimeMillis() - 10000000));
        Producer p11 = new Producer("DidakaMadafaka", countryRepository.findById((long) 4).orElse(null), Instant.now(), Instant.ofEpochMilli(System.currentTimeMillis() - 10000000));



        producerRepository.save(p1);
        producerRepository.save(p11);


        Writer w1 = new Writer("az", countryRepository.findById((long) 3).orElse(null), Instant.now(), Instant.ofEpochMilli(System.currentTimeMillis() - 10000000));
        Writer w11 = new Writer("Tommyto", countryRepository.findById((long) 4).orElse(null), Instant.now(), Instant.ofEpochMilli(System.currentTimeMillis() - 10000000));



        writerRepository.save(w1);
        writerRepository.save(w11);

    }

}
