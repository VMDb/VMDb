package com.kaufland.vmdb.database.repo;

import com.kaufland.vmdb.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAllByTitle(String title);

    List<Movie> findAllByTitleLike(String title);

}
