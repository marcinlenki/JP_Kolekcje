package com.lenkiewiczmarcin;

import java.util.*;

public class Main {

    // ConsoleUserDialog to pomocnicza klasa zawierająca zestaw
    // prostych metod do realizacji dialogu z użytkownikiem
	// w oknie konsoli tekstowej.
    private static final ConsoleUserDialog console = new ConsoleUserDialog();

    // Zainicjalizowane obiekty klasy Person oraz PersonOverridden służace do
    // pokazania różnic między różnymi kolekcjami i mapami
    private static final Person person1 = new Person("Marcin","Lenkiewicz");
    private static final Person person2 = new Person("Jakub","Kowalski");
    private static final Person person3 = new Person("Bartosz","Nowicki");
    private static final Person person4 = new Person("Marcin","Lenkiewicz");
    private static final Person person5 = new Person("Ksawery","Grabowski");


    private static final Person person6 = new PersonOverridden("Marcin","Lenkiewicz");
    private static final Person person7 = new PersonOverridden("Jakub","Kowalski");
    private static final Person person8 = new PersonOverridden("Bartosz","Nowicki");
    private static final Person person9 = new PersonOverridden("Marcin","Lenkiewicz");
    private static final Person person10 = new PersonOverridden("Ksawery","Grabowski");

    // Kolekcje oraz mapy na których realizowane będą przykłady.
    // Podzielone na te przyjmujące obiekty Person (bez nadpisanych metod equals() oraz hashcode()) oraz
    // te przyjmujące obiekty PersonOverridden (nadpisane metody equals() oraz hashcode()).
    private static final List<Person> arrayList = new ArrayList<>();
    private static final List<Person> linkedList = new LinkedList<>();
    private static final Set<Person> hashSet = new HashSet<>();
    private static final Set<Person> treeSet = new TreeSet<>();
    private static final Map<Integer, Person> hashMap = new HashMap<>();
    private static final Map<Integer, Person> treeMap = new TreeMap<>();


    private static final List<Person> arrayListOverridden = new ArrayList<>();
    private static final List<Person> linkedListOverridden = new LinkedList<>();
    private static final Set<Person> hashSetOverridden = new HashSet<>();
    private static final Set<Person> treeSetOverridden = new TreeSet<>();
    private static final Map<Integer, Person> hashMapOverridden = new HashMap<>();
    private static final Map<Integer, Person> treeMapOverridden = new TreeMap<>();



    public static void main(String[] args){
        runMainLoop();
    }

    private static void showMenu() {
        console.printMessage("\n        M E N U   G Ł Ó W N E  ");
        console.printMessage("Naciśnij: ");
        console.printMessage("1. aby dodać obiekt do różnych kolekcji.");
        console.printMessage("2. aby usunąć obiekt z różnych kolekcji.");
        console.printMessage("3. aby iterować po obiektach różnych kolekcji.");
        console.printMessage("4. aby zakończyć działanie programu.");
        console.printMessageSameLine("Wybór: ");

    }

    // Metoda pokazuje możliwe do dodania elementy.
    private static void showAllAvailableObjects() {
        console.printMessage("==============================");
        console.printMessage(person1);
        console.printMessage(person2);
        console.printMessage(person3);
        console.printMessage(person4);
        console.printMessage(person5);
        console.printMessage("==============================");
    }

    // Metoda wykonywująca główną pętle aplikacji.
    // Daje możliwość dodawania elementów do kolekcji i map, ich usuwanie,
    // iteracje po obiektach oraz wyjście z aplikacji.
    private static void runMainLoop() {
        boolean quit = false;

        while (!quit) {
            showMenu();
            int wybor = console.enterInt();
            switch (wybor) {
                case 1 -> addToCollections();
                case 2 -> removeFromCollection();
                case 3 -> {
                    showCollection(arrayList);
                    console.printMessageSameLine("Overridden ");
                    showCollection(arrayListOverridden);

                    showCollection(linkedList);
                    console.printMessageSameLine("Overridden ");
                    showCollection(linkedListOverridden);

                    showCollection(hashSet);
                    console.printMessageSameLine("Overridden ");
                    showCollection(hashSetOverridden);

                    showCollection(treeSet);
                    console.printMessageSameLine("Overridden ");
                    showCollection(treeSetOverridden);

                    showMap(hashMap);
                    console.printMessageSameLine("Overridden ");
                    showMap(hashMapOverridden);

                    showMap(treeMap);
                    console.printMessageSameLine("Overridden ");
                    showMap(treeMapOverridden);

                    console.waitForKey();
                    console.printMessageSameLine("Naciśnij dowolny przycisk, aby kontynuować... ");
                    console.waitForKey();
                }
                case 4 -> quit = true;
                default -> console.printMessage("Nieprawdidłowa wartość");
            }
            console.clearConsole();
        }
    }

    // Metoda służy dodaniu wybraego elementu do wszystkich dostępnych kolekcji oraz map.
    private static void addToCollections() {
        console.waitForKey();
        console.printMessage("");
        showAllAvailableObjects();
        console.printMessageSameLine("Który element chcesz dodać?: ");
        int wybor = console.enterInt();
        console.waitForKey();
        String wyborK;
        int key;
        do {
            console.printMessageSameLine("Proszę dobrać klucz (liczbę całkowitą), którym będzie charakteryzować się wybrany element w mapach: ");
            key = console.enterInt();
            console.waitForKey();
            wyborK = "";
            if (hashMap.containsKey(key)) {
                console.printMessage("Wybrany klucz jest zajęty!");
                console.printMessageSameLine("Zajęte klucze: [");
                for (Map.Entry<Integer, Person> p : hashMap.entrySet()) {
                    console.printMessageSameLine(p.getKey() + ", ");
                }
                console.printMessage("]");
                console.printMessageSameLine("Czy chcesz wybrać nowy klucz? (T/N):  ");
                wyborK = console.enterString();
            }
        }
        while (wyborK.equals("T") || wyborK.equals("t"));

        Person currentPerson = null;
        PersonOverridden currentPersonOverridden = null;

        switch (wybor) {
            case 1 -> {
                currentPerson = person1;
                currentPersonOverridden = (PersonOverridden) person6;
            }
            case 2 -> {
                currentPerson = person2;
                currentPersonOverridden = (PersonOverridden) person7;
            }
            case 3 -> {
                currentPerson = person3;
                currentPersonOverridden = (PersonOverridden) person8;
            }
            case 4 -> {
                currentPerson = person4;
                currentPersonOverridden = (PersonOverridden) person9;
            }
            case 5 -> {
                currentPerson = person5;
                currentPersonOverridden = (PersonOverridden) person10;
            }
            default -> console.printMessage("Nieprawdidłowa wartość");
        }


        if (currentPerson == null)
            return;

        arrayList.add(currentPerson);
        linkedList.add(currentPerson);
        hashSet.add(currentPerson);
        treeSet.add(currentPerson);
        hashMap.put(key, currentPerson);
        treeMap.put(key, currentPerson);


        arrayListOverridden.add(currentPersonOverridden);
        linkedListOverridden.add(currentPersonOverridden);
        hashSetOverridden.add(currentPersonOverridden);
        treeSetOverridden.add(currentPersonOverridden);
        hashMapOverridden.put(key, currentPersonOverridden);
        treeMapOverridden.put(key, currentPersonOverridden);
    }


    // Metoda służy usunięciu wybraego elementu ze wszystkich dostępnych kolekcji oraz map.
    private static void removeFromCollection() {
        showAllAvailableObjects();
        console.printMessageSameLine("Który element chcesz usunąć?: ");
        int wybor = console.enterInt();
        console.waitForKey();
        Person currentPerson = null;
        PersonOverridden currentPersonOverridden = null;
        switch (wybor) {
            case 1 -> {
                currentPerson = person1;
                currentPersonOverridden = (PersonOverridden) person6;
            }
            case 2 -> {
                currentPerson = person2;
                currentPersonOverridden = (PersonOverridden) person7;
            }
            case 3 -> {
                currentPerson = person3;
                currentPersonOverridden = (PersonOverridden) person8;
            }
            case 4 -> {
                currentPerson = person4;
                currentPersonOverridden = (PersonOverridden) person9;
            }
            case 5 -> {
                currentPerson = person5;
                currentPersonOverridden = (PersonOverridden) person10;
            }
            default -> console.printMessage("Nieprawdidłowa wartość");
        }

        if (currentPerson == null)
            return;

        int key = 0;

        if (!hashMap.isEmpty()) {
            iterateMap(hashMap);
            console.printMessageSameLine("Wybierz klucz dla elementu któru chcesz usunąć: ");
            key = console.enterInt();
            console.waitForKey();
            while (!hashMap.containsKey(key)) {
                console.printMessageSameLine("Wybrany klucz nie istnieje. Wybierz ponownie: ");
                key = console.enterInt();
            }
        }
        arrayList.remove(currentPerson);
        linkedList.remove(currentPerson);
        hashSet.remove(currentPerson);
        treeSet.remove(currentPerson);
        hashMap.remove(key);
        treeMap.remove(key);

        arrayListOverridden.remove(currentPersonOverridden);
        linkedListOverridden.remove(currentPersonOverridden);
        hashSetOverridden.remove(currentPersonOverridden);
        treeSetOverridden.remove(currentPersonOverridden);
        hashMapOverridden.remove(key);
        treeMapOverridden.remove(key);
    }

    // Metoda służąca do iterowania po elementach wybranej mapy.
    // Używa zamianę mapy na odpowiadający jej hashSet oraz
    // wypisywanie elementów za pomocą pętli forEach.
    private static void iterateMap(Map<Integer, Person> map) {
        if (map.isEmpty())
            console.printMessage("Pusto");

        else {
            for (Map.Entry<Integer, Person> p : map.entrySet()) {
                console.printMessage(p);
            }
        }
    }

    // Metoda służąca do iterowania po elementach wybranej kolekcji.
    // Wypisywanie elementów za pomocą iteratora.
    private static void iterateCollection(Collection<Person> collection) {
        if (collection.isEmpty())
            console.printMessage("Pusto");

        else {
            Iterator<Person> iterator = collection.iterator();
            while (iterator.hasNext())
                console.printMessage(iterator.next());
        }
    }

    // Metoda służąca do wypisania zgodnie z przyjętym szablonem graficznym wszystkich elementów kolekcji.
    private static void showCollection(Collection<Person> collection) {
        String s = collection.getClass().toString();
        StringBuilder sb = new StringBuilder(s);
        s = sb.substring(16);
        console.printMessage(s);

        console.printMessage("==============================");
        iterateCollection(collection);
        console.printMessage("==============================");
        console.printMessage("");
    }

    // Metoda służąca do wypisania zgodnie z przyjętym szablonem graficznym wszystkich elementów mapy.
    private static void showMap(Map<Integer, Person> map) {
        String s = map.getClass().toString();
        s = new StringBuilder(s).substring(16);
        console.printMessage(s);

        console.printMessage("==============================");
        iterateMap(map);
        console.printMessage("==============================");
        console.printMessage("");
    }
}
