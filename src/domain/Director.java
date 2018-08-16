package domain;

import java.time.Instant;

public class Director extends Human {

    public Director() {
        super();
        this.role = HumanRole.DIRECTOR;
    }

    public Director(long id, String name, Country country, Instant dateOfBirth, Instant careerStart) {
        super(id, HumanRole.DIRECTOR, name, country, dateOfBirth, careerStart);
    }
}
