package com.kaufland.vmdb.service.impl;

import com.kaufland.vmdb.database.repo.DirectorRepository;
import com.kaufland.vmdb.domain.Director;
import com.kaufland.vmdb.service.DirectorService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DirectorServiceImpl implements DirectorService {

    private final DirectorRepository directorRepository;

    public DirectorServiceImpl(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    public List<Director> findAll() {
        return directorRepository.findAll();
    }

    @Override
    public List<Director> findByNameIn(List<String> names) {
        return directorRepository.findAllByNameIn(names);
    }
}
