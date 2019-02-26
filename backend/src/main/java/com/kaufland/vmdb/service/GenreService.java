package com.kaufland.vmdb.service;


import com.kaufland.vmdb.domain.Genre;

import java.util.List;

public interface GenreService {

    List<Genre> findGenresIn(List<String> names);

}
