package domain;

import java.time.Instant;

public class Producer extends Human {

    public Producer() {
        super();
        this.role = HumanRole.PRODUCER;
    }

    public Producer(long id, String name, Country country, Instant dateOfBirth, Instant careerStart) {
        super(id, HumanRole.PRODUCER, name, country, dateOfBirth, careerStart);
    }
}
