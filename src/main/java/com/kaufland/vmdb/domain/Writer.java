package com.kaufland.vmdb.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.Instant;

@Entity
@DiscriminatorValue("writer")
public class Writer extends Human {

    public Writer() {
        super();
    }

    public Writer(long id, String name, Country country, Instant dateOfBirth, Instant careerStart) {
        super(id, name, country, dateOfBirth, careerStart);
    }
}