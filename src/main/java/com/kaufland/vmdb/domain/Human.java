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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Instant getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Instant dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Instant getCareerStart() {
        return careerStart;
    }

    public void setCareerStart(Instant careerStart) {
        this.careerStart = careerStart;
    }

    public Human(String name, Country country, Instant dateOfBirth, Instant careerStart) {
        this.name = name;
        this.country = country;
        this.dateOfBirth = dateOfBirth;
        this.careerStart = careerStart;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                ", dateOfBirth=" + dateOfBirth +
                ", careerStart=" + careerStart +
                '}';
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
