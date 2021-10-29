package com.lenkiewiczmarcin;

/*
 * Klasa reprezentująca osobę.
 * Opisana za pomocą 4 atrybutów: imię, nazwisko, unikatowy numer indeksu oraz statyczne pole indexCount które zlicza utworzone obiekty Person.
 * Klasa nie ma nadpisanych metod equals() oraz hashcode().
 */

public class Person implements Comparable<Person>, Cloneable {

    private String name;
    private String lastName;
    private int index ;
    private static int indexCount = 1;  //Pole automatycznie inkrementowane przy wywołaniu konstruktora.

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.index = indexCount++;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return " [" + index + "]\t" + name + " " + lastName;
    }


    // Nadpisana metoda compareTo wywodząca się z interfejsu Comparable pozwala sortować obiekty typu Person po imieniu.
    // Metoda używana jest przez treeSet oraz treeMap.
    // Pozwala na dodanie dwóch różnych obiektów o tym samym imieniu.
    @Override
    public int compareTo(Person o) {
        if (this.equals(o))
            return 0;

        if (this.name.compareTo(o.name) >= 0)
            return 1;

        else return -1;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
