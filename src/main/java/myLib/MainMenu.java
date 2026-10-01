package myLib;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    public enum Options {
        NONE,
        READ,
        WRITE,
        EXIT
    }

    public void newMenu() {
        Scanner scanner = new Scanner(System.in);
        Options userOption = Options.NONE;

        while (userOption != Options.EXIT) {
            printMenu();

            try {
                userOption = Options.values()[scanner.nextInt() - 1];
            } catch (InputMismatchException e) {
                System.out.println("Wrong type of data.");
                scanner.nextLine();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Insert a valid option.");
            }

            processOption(userOption);
        }
    }

    private void printMenu() {
        int optionIndex = 1;

        System.out.println("---------------------");
        for (Options option : Options.values()) {
            if (option != Options.NONE) {
                System.out.println(optionIndex + ". " + option.toString());
                optionIndex++;
            }
        }
        System.out.println("---------------------");

        System.out.println("Input the option: ");
    }

    private void processOption(Options userOption) {

    }
}

