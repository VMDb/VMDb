package com.kaufland.vmdb.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.Instant;

@Entity
@DiscriminatorValue("producer")
public class Producer extends Human {

    public Producer() {
        super();
    }

    public Producer(long id, String name, Country country, Instant dateOfBirth, Instant careerStart) {
        super(id, name, country, dateOfBirth, careerStart);
    }
}
