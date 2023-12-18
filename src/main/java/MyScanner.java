import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class MyScanner {
    static Scanner getScanner(String file) {
        return new Scanner(MyScanner.class.getResourceAsStream(file));
    }

    @SneakyThrows
    static List<String> readInput(String file) {
        return Files.readAllLines(Paths.get(MyScanner.class.getClassLoader()
                .getResource(file)
                .toURI()));
    }
}
