package domain;

import java.time.Instant;

public class Writer extends Human {

    public Writer() {
        super();
        this.role = HumanRole.WRITER;
    }

    public Writer(long id, String name, Country country, Instant dateOfBirth, Instant careerStart) {
        super(id, HumanRole.WRITER, name, country, dateOfBirth, careerStart);
    }
}
