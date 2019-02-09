package com.kaufland.vmdb.service.impl;

import com.kaufland.vmdb.database.repo.*;
import com.kaufland.vmdb.domain.*;
import com.kaufland.vmdb.service.MovieInsertionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieInsertionServiceImpl implements MovieInsertionService {

    private final ActorRepository actorRepository;
    private final ProducerRepository producerRepository;
    private final WriterRepository writerRepository;
    private final DirectorRepository directorRepository;
    private final CountryRepository countryRepository;
    private final GenreRepository genreRepository;

    @Autowired
    public MovieInsertionServiceImpl(ActorRepository actorRepository, ProducerRepository producerRepository, WriterRepository writerRepository, DirectorRepository directorRepository, CountryRepository countryRepository, GenreRepository genreRepository) {
        this.actorRepository = actorRepository;
        this.producerRepository = producerRepository;
        this.writerRepository = writerRepository;
        this.directorRepository = directorRepository;
        this.countryRepository = countryRepository;
        this.genreRepository = genreRepository;
    }


    @Override
    public <T extends Human> List<T> findCrewOfTypeAndNames(Class<T> type, List<String> names) {
        List<T> list = new ArrayList<>();
        if(type.equals(Actor.class)){
            names.forEach(name -> list.add((T) actorRepository.findByName(name)));
        }
        if(type.equals(Writer.class)){
            names.forEach(name -> list.add((T) writerRepository.findByName(name)));
        }
        if(type.equals(Producer.class)){
            names.forEach(name -> list.add((T) producerRepository.findByName(name)));
        }
        if(type.equals(Director.class)){
            names.forEach(name -> list.add((T) directorRepository.findByName(name)));
        }
        return list;
    }

    @Override
    public List<Genre> findGenresByNames(List<String> genres) {
        return genres.stream().map(genreRepository::findByName).collect(Collectors.toList());
    }

    @Override
    public Country findCountryByName(String country) {
        return countryRepository.findByName(country);
    }
}
