package com.kaufland.vmdb.service.impl;


import com.kaufland.vmdb.database.repo.GenreRepository;
import com.kaufland.vmdb.domain.Genre;
import com.kaufland.vmdb.service.GenreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> findGenresIn(List<String> names) {
        return genreRepository.findAllByNameIn(names);
    }
}
