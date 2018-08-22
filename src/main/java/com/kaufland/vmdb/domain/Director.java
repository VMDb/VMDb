package com.kaufland.vmdb.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.Instant;

@Entity(name = "director")
public class Director extends Human {

    public Director() {
        super();
    }

    public Director(long id, String name, Country country, Instant dateOfBirth, Instant careerStart) {
        super(id, name, country, dateOfBirth, careerStart);
    }
}
