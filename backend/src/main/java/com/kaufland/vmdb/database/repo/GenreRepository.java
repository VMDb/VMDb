package com.kaufland.vmdb.database.repo;

import com.kaufland.vmdb.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    List<Genre> findAllByName(String name);

    Genre findByName(String name);

    List<Genre> findAllByNameIn(List<String> names);

}
