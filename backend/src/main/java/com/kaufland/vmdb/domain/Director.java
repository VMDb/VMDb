package com.kaufland.vmdb.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.Instant;

@Entity(name = "director")
public class Director extends Human {

    public Director() {
        super();
    }

    public Director(String name, Country country, Instant dateOfBirth, Instant careerStart) {
        super(name, country, dateOfBirth, careerStart);
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                ", dateOfBirth=" + dateOfBirth +
                ", careerStart=" + careerStart +
                '}';
    }
}
