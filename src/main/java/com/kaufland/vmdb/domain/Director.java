package com.kaufland.vmdb.domain;

import java.time.Instant;

public class Director extends Human {

    public Director() {
        super();
    }

    public Director(long id, String name, Country country, Instant dateOfBirth, Instant careerStart) {
        super(id, name, country, dateOfBirth, careerStart);
    }
}
