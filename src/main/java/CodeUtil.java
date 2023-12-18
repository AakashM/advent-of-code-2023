import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class CodeUtil {
    static Scanner getScanner(String file) {
        return new Scanner(CodeUtil.class.getResourceAsStream(file));
    }

    @SneakyThrows
    static List<String> readInput(String file) {
        return Files.readAllLines(Paths.get(CodeUtil.class.getClassLoader()
                .getResource(file)
                .toURI()));
    }
}
