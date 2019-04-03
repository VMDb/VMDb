package com.kaufland.vmdb.service.impl;

import com.kaufland.vmdb.database.repo.WriterRepository;
import com.kaufland.vmdb.domain.Writer;
import com.kaufland.vmdb.service.WriterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WriterServiceImpl implements WriterService {

    private final WriterRepository writerRepository;

    public WriterServiceImpl(WriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }

    @Override
    public List<Writer> findAll() {
        return writerRepository.findAll();
    }

    @Override
    public List<Writer> findByNameIn(List<String> names) {
        return writerRepository.findAllByNameIn(names);
    }
}
