package myLib;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BackupMenu {
    enum Options {
        NONE,
        FULL_BACKUP,
        INCREMENTAL_BACKUP,
        EXIT
    }

    public void newBackupMenu() {
        Scanner scanner = new Scanner(System.in);
        Options userOption = Options.NONE;

        while (userOption != Options.EXIT) {
            printMenu();

            try {
                userOption = Options.values()[scanner.nextInt()];
                processOption(userOption);
            } catch (InputMismatchException e) {
                System.out.println("Wrong type of data.");
                scanner.nextLine();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Insert a valid option.");
            }
        }
    }

    private void printMenu() {
        int index = 0;

        System.out.println("---------------------");
        for (Options option : Options.values()) {
            if (option != Options.NONE) System.out.println(++index + ". " + option);
        }
        System.out.println("---------------------");

        System.out.println("Input the option: ");
    }

    private void processOption(Options userOption) {
        BackupService backupService = new BackupService();

        switch (userOption) {
            case FULL_BACKUP -> backupService.fullBackup();
            case INCREMENTAL_BACKUP -> backupService.incrementalBackup();
            case EXIT -> System.exit(0);
        }
    }
}
