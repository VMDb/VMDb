package com.kaufland.vmdb.domain;

import javax.persistence.Entity;

import java.time.Instant;

@Entity(name = "writer")
public class Writer extends Human {

    public Writer() {
        super();
    }

    public Writer(String name, Country country, Instant dateOfBirth, Instant careerStart) {
        super(name, country, dateOfBirth, careerStart);
    }

    @Override
    public String toString() {

        return "Writer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                ", dateOfBirth=" + dateOfBirth +
                ", careerStart=" + careerStart +
                '}';
    }
}
