package com.kaufland.vmdb.service;

import com.kaufland.vmdb.domain.Country;
import com.kaufland.vmdb.domain.Genre;
import com.kaufland.vmdb.domain.Human;

import java.util.List;

public interface MovieInsertionService {

    <T extends Human> List<T> findCrewOfTypeAndNames(Class<T> type, List<String> names);

    List<Genre> findGenresByNames(List<String> genres);

    Country findCountryByName(String country);


}
