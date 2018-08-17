package domain;

import java.time.Instant;

public class Producer extends Human {

    public Producer() {
        super();
    }

    public Producer(long id, String name, Country country, Instant dateOfBirth, Instant careerStart) {
        super(id, name, country, dateOfBirth, careerStart);
    }
}
