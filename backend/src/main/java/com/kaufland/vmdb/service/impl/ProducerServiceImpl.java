package com.kaufland.vmdb.service.impl;

import com.kaufland.vmdb.database.repo.ProducerRepository;
import com.kaufland.vmdb.domain.Producer;
import com.kaufland.vmdb.service.ProducerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerServiceImpl implements ProducerService {

    private final ProducerRepository producerRepository;

    public ProducerServiceImpl(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    @Override
    public List<Producer> findAll() {
        return producerRepository.findAll();
    }

    @Override
    public List<Producer> findByNameIn(List<String> names) {
        return producerRepository.findAllByNameIn(names);
    }
}
