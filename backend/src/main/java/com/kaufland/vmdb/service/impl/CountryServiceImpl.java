package com.kaufland.vmdb.service.impl;

import com.kaufland.vmdb.database.repo.CountryRepository;
import com.kaufland.vmdb.domain.Country;
import com.kaufland.vmdb.service.CountryService;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country getCountryFromName(String name) {
        return countryRepository.findByName(name);
    }
}
