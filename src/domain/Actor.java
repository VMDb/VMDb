package domain;

import java.time.Instant;

public class Actor extends Human {

    public Actor() {
        super();
        this.role = HumanRole.ACTOR;
    }

    public Actor(long id, String name, Country country, Instant dateOfBirth, Instant careerStart) {
        super(id, HumanRole.ACTOR, name, country, dateOfBirth, careerStart);
    }
}
