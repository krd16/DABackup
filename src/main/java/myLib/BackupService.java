package myLib;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

public class BackupService {
    Path resourcesPath = Path.of("src/main/resources/original");

    public void fullBackup() {
        try {
            Files.copy(resourcesPath, Path.of("target/" + LocalDate.now()));
        } catch (IOException e) {
            System.out.println("Something went wrong while fetching directory");
        }
    }

    public void incrementalBackup() {

    }
}
