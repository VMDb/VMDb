package com.kaufland.vmdb.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.Instant;

@Entity(name = "actor")
public class Actor extends Human {

    public Actor() {
        super();
    }

    public Actor(String name, Country country, Instant dateOfBirth, Instant careerStart) {
        super(name, country, dateOfBirth, careerStart);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                ", dateOfBirth=" + dateOfBirth +
                ", careerStart=" + careerStart +
                '}';
    }
}
