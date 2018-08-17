package domain;

import java.time.Instant;

public class Writer extends Human {

    public Writer() {
        super();
    }

    public Writer(long id, String name, Country country, Instant dateOfBirth, Instant careerStart) {
        super(id, name, country, dateOfBirth, careerStart);
    }
}
