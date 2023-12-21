import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;

public class Day9Test {
    @Test
    void solveExampleA() {
        long output = new Day9().solveA(getInput("day9-example.txt"));
        Assertions.assertEquals(114, output);
    }

    @Test
    void solveInputA() {
        long output = new Day9().solveA(getInput("day9-input.txt"));
        Assertions.assertEquals(1637452029, output);
    }

    @Test
    void solveExampleB() {
        long output = new Day9().solveB(getInput("day9-example.txt"));
        Assertions.assertEquals(2, output);
    }

    @Test
    void solveInputB() {
        long output = new Day9().solveB(getInput("day9-input.txt"));
        Assertions.assertEquals(908, output);
    }

    List<List<Integer>> getInput(String file) {
        var lines = TestUtil.readInput(file);
        return lines.stream()
                .map(line -> new Scanner(line).tokens().map(Integer::parseInt).toList())
                .toList();
    }
}


