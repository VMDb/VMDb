package com.kaufland.vmdb.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.Instant;

@Entity(name = "producer")
public class Producer extends Human {

    public Producer() {
        super();
    }

    public Producer(String name, Country country, Instant dateOfBirth, Instant careerStart) {
        super(name, country, dateOfBirth, careerStart);
    }

    @Override
    public String toString() {
        return "Producer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                ", dateOfBirth=" + dateOfBirth +
                ", careerStart=" + careerStart +
                '}';
    }
}
