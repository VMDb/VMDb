package com.kaufland.vmdb.dto;

import com.kaufland.vmdb.domain.Country;
import com.kaufland.vmdb.domain.Human;

import javax.persistence.ManyToOne;
import java.time.Instant;

public class HumanDTO {

    private String name;

    private String country;

    private Instant dateOfBirth;

    private Instant careerStart;

    public HumanDTO(Human human){
        this.name = human.getName();
        this.country = human.getCountry().getName();
        this.dateOfBirth = human.getDateOfBirth();
        this.careerStart = human.getCareerStart();
    }

    public HumanDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public HumanDTO(String name, String country, Instant dateOfBirth, Instant careerStart) {
        this.name = name;
        this.country = country;
        this.dateOfBirth = dateOfBirth;
        this.careerStart = careerStart;
    }
}
