package com.kaufland.vmdb.domain;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Inheritance(strategy =  InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public abstract class Human {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    protected String name;
    
    @ManyToOne
    protected Country country;

    protected Instant dateOfBirth;

    protected Instant careerStart;

    public Human(long id, String name, Country country, Instant dateOfBirth, Instant careerStart) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.dateOfBirth = dateOfBirth;
        this.careerStart = careerStart;
    }

    public Human() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return id == human.id &&
                Objects.equals(name, human.name) &&
                Objects.equals(country, human.country) &&
                Objects.equals(dateOfBirth, human.dateOfBirth) &&
                Objects.equals(careerStart, human.careerStart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country, dateOfBirth, careerStart);
    }
}
