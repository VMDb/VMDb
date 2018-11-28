package com.kaufland.vmdb.database.repo;

import com.kaufland.vmdb.domain.Genre;
import com.kaufland.vmdb.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAllByTitle(String title);

    List<Movie> findAllByTitleLike(String title);

    List<Movie> findAllByPlotLike(String plot);

    List<Movie> findAllByGenresIn(Genre... genres);
}
