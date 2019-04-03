package com.kaufland.vmdb.dto;

import com.kaufland.vmdb.domain.Country;
import com.kaufland.vmdb.domain.Human;

import javax.persistence.ManyToOne;
import java.time.Instant;

public class HumanModel {

    private String name;

    private String countryName;

    private Instant dateOfBirth;

    private Instant careerStart;

    public HumanModel(Human human){
        this.name = human.getName();
        this.countryName = human.getCountry().getName();
        this.dateOfBirth = human.getDateOfBirth();
        this.careerStart = human.getCareerStart();
    }

    public HumanModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return countryName;
    }

    public void setCountry(String country) {
        this.countryName = country;
    }

    public Instant getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Instant dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Instant getCareerStart() {
        return careerStart;
    }

    public void setCareerStart(Instant careerStart) {
        this.careerStart = careerStart;
    }

    public HumanModel(String name, String country, Instant dateOfBirth, Instant careerStart) {
        this.name = name;
        this.countryName = country;
        this.dateOfBirth = dateOfBirth;
        this.careerStart = careerStart;
    }
}
