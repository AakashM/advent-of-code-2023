import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;


public class TestInput {
    @SneakyThrows
    static Scanner getScanner(String file) {
        return new Scanner(getPath(file));
    }

    @SneakyThrows
    static List<String> readInput(String file) {
        return Files.readAllLines(getPath(file));
    }

    @SneakyThrows
    private static Path getPath(String file) {
        return Paths.get(TestInput.class.getResource(file).toURI());
    }
}
