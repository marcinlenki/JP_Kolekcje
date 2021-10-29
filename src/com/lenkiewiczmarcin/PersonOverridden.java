package com.lenkiewiczmarcin;

/*
 * Klasa reprezentująca osobę, dziedziczy po klasie Person.
 * Klasa ma nadpisane metody equals() oraz hashcode().
 */

import java.util.Objects;

public class PersonOverridden extends Person {

    public PersonOverridden(String name, String lastName) {
        super(name, lastName);
    }

    // Nadpisanie metody eqauls() powoduje, że dwa obiekty typu PersonOverridden są równe jeśli ich imię i nazwisko się zgadzają.
    // Wykorzystywane przy dodawaniu oraz usuwaniu elementów z hasSetu oraz treeSetu.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getName().equals(person.getName()) && getLastName().equals(person.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLastName());
    }

    @Override
    public String toString() {
        return super.toString() + ", equals() i hashCode() nadpisane";
    }
}