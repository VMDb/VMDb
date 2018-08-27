package com.kaufland.vmdb.database.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface NameSearchableRepository<T> extends JpaRepository<T, Long> {

    T findByName(String name);

    List<T> findAllByName(String name);
}
