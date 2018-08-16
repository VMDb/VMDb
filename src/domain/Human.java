package domain;

import java.time.Instant;

public abstract class Human {

    protected long id;
    protected HumanRole role;
    protected String name;
    protected Country country;
    protected Instant dateOfBirth;
    protected Instant careerStart;

    public Human(long id, HumanRole role, String name, Country country, Instant dateOfBirth, Instant careerStart) {
        this.id = id;
        this.role = role;
        this.name = name;
        this.country = country;
        this.dateOfBirth = dateOfBirth;
        this.careerStart = careerStart;
    }

    public Human() {
    }
}
