package com.kaufland.vmdb.database.repo;

import com.kaufland.vmdb.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends NameSearchableRepository<Country>{

}
