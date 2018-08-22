package com.kaufland.vmdb.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.Instant;

@Entity(name = "actor")
public class Actor extends Human {

    public Actor() {
        super();
    }

    public Actor(long id, String name, Country country, Instant dateOfBirth, Instant careerStart) {
        super(id, name, country, dateOfBirth, careerStart);
    }
}
