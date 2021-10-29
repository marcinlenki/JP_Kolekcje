package com.lenkiewiczmarcin;
/*
 * Klasa zawierająca metody służąące do komunikacji z użytkownikiem używająć konsoli.
*/


import java.util.Scanner;

public class ConsoleUserDialog {

    private final static Scanner scanner = new Scanner(System.in);
    private final String  ERROR_MESSAGE =
            "Nieprawidłowe dane!\nSpróbuj jeszcze raz.";

    public void printMessage(Object message) {
        System.out.println(message);
    }

    public void printMessageSameLine(String message) {
        System.out.print(message);
    }

    public void waitForKey() {
        scanner.nextLine();
    }

    public int enterInt() {
        int wybor;

        while (!(scanner.hasNextInt())) {
            printMessage(ERROR_MESSAGE);
            scanner.nextLine();
            System.out.print("Wybór: ");
        }

        wybor = scanner.nextInt();

        return wybor;
    }

    public String enterString() {
        String wybor = scanner.nextLine();

        while (!(wybor.equals("T") || wybor.equals("t") || wybor.equals("N") || wybor.equals("n"))) {
            printMessage(ERROR_MESSAGE);
            printMessageSameLine("Wybór: ");
            wybor = scanner.nextLine();
        }

        return wybor;
    }

    public void clearConsole() {
        System.out.println("\n\n\n");
    }

}