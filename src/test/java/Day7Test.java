import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day7Test {
    @Test
    void solveExampleA() {
        long output = new Day7().solveA(getInput("day7-example.txt"));
        Assertions.assertEquals(6440, output);
    }

    @Test
    void solveInputA() {
        long output = new Day7().solveA(getInput("day7-input.txt"));
        Assertions.assertEquals(251058093, output);
    }

    @Test
    void solveExampleB() {
        long output = new Day7().solveB(getInput("day7-example.txt"));
        Assertions.assertEquals(5905, output);
    }

    @Test
    void solveInputB() {
        long output = new Day7().solveB(getInput("day7-input.txt"));
        Assertions.assertEquals(249781879, output);
    }

    List<Day7.Hand> getInput(String file) {
        var lines = TestUtil.readInput(file);
        return lines.stream()
                .map(line -> {
                    Scanner sc = new Scanner(line);
                    return new Day7.Hand(sc.next(), sc.nextInt());
                })
                .toList();
    }
}


