package com.kaufland.vmdb.domain;

import java.time.Instant;

public class Actor extends Human {

    public Actor() {
        super();
    }

    public Actor(long id, String name, Country country, Instant dateOfBirth, Instant careerStart) {
        super(id, name, country, dateOfBirth, careerStart);
    }
}
