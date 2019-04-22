package com.kaufland.vmdb.service.impl;

import com.kaufland.vmdb.database.repo.ActorRepository;
import com.kaufland.vmdb.database.repo.DirectorRepository;
import com.kaufland.vmdb.database.repo.ProducerRepository;
import com.kaufland.vmdb.database.repo.WriterRepository;
import com.kaufland.vmdb.domain.*;
import com.kaufland.vmdb.service.CrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrewServiceImpl implements CrewService {

    private final ActorRepository actorRepository;
    private final ProducerRepository producerRepository;
    private final WriterRepository writerRepository;
    private final DirectorRepository directorRepository;

    @Autowired
    public CrewServiceImpl(ActorRepository actorRepository, ProducerRepository producerRepository, WriterRepository writerRepository, DirectorRepository directorRepository) {
        this.actorRepository = actorRepository;
        this.producerRepository = producerRepository;
        this.writerRepository = writerRepository;
        this.directorRepository = directorRepository;
    }

    @Override
    public <T extends Human> List<T> findCrewByRole(Class<T> role) {
        if(role.equals(Actor.class)){
            return (List<T>) actorRepository.findAll();
        }
        else if(role.equals(Writer.class)){
            return (List<T>) writerRepository.findAll();
        }
        else if(role.equals(Producer.class)){
            return (List<T>) producerRepository.findAll();
        }
        else
            return (List<T>) directorRepository.findAll();
    }
}
