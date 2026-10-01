package myLib;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Scanner;

public class FileReader {
    private boolean isValidPath(String userPath) {
        try {
            Path.of(userPath);
            return true;
        } catch (InvalidPathException | NullPointerException e) {
            return false;
        }
    }

    public Path fileToRead() {
        Scanner sc = new Scanner(System.in);
        Path validPath = null;

        while (validPath == null) {
            System.out.print("Introduce la ruta del archivo: ");
            String input = sc.nextLine();

            if (!isValidPath(input)) {
                System.out.println("La sintaxis de la ruta no es correcta.");
            } else {
                Path candidate = Path.of(input);

                if (!Files.exists(candidate)) {
                    System.out.println("El archivo no existe.");
                } else if (!Files.isReadable(candidate)) {
                    System.out.println("El archivo no se puede leer.");
                } else {
                    validPath = candidate;
                }
            }
        }

        return validPath;
    }
}