package com.kaufland.vmdb.service.impl;

import com.kaufland.vmdb.database.repo.ActorRepository;
import com.kaufland.vmdb.domain.Actor;
import com.kaufland.vmdb.service.ActorService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public List<Actor> findByNameIn(List<String> names) {
        return actorRepository.findAllByNameIn(names);
    }
}
