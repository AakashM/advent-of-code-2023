import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Day6Test {
    @Test
    void solveExampleA() {
        long output = new Day6().solveA(getInput("day6-example.txt"));
        Assertions.assertEquals(288, output);
    }

    @Test
    void solveInputA() {
        long output = new Day6().solveA(getInput("day6-input.txt"));
        Assertions.assertEquals(4811940, output);
    }

    @Test
    void solveExampleB() {
        long output = new Day6().solveB(new Race(71530, 940200));
        Assertions.assertEquals(71503, output);
    }

    @Test
    void solveInputB() {
        long output = new Day6().solveB(new Race(41968894,214178911271055L));
        Assertions.assertEquals(30077773, output);
    }

    List<Race> getInput(String file) {
        var lines = TestUtil.readInput(file);
        var line1Scanner = new Scanner(lines.get(0));
        line1Scanner.next();
        var line2Scanner = new Scanner(lines.get(1));
        line2Scanner.next();
        var races = new ArrayList<Race>();
        while(line1Scanner.hasNextInt()) {
            races.add(new Race(line1Scanner.nextLong(), line2Scanner.nextLong()));
        }
        System.out.println(races);
        return races;
    }
}


