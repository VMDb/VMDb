package com.kaufland.vmdb.database.repo;

import com.kaufland.vmdb.domain.Country;
import com.kaufland.vmdb.domain.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface HumanRepository<T extends Human> extends NameSearchableRepository<T>{

    List<T> findAllByNameLike   (String name);

    List<T> findAllByCountry    (Country country);

    List<T> findAllByCountryName(String name);
}
