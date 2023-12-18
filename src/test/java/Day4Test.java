import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day4Test {
    @Test
    void solveExampleA() {
        long output = new Day4().solveA(getInput("day4-example.txt"));
        Assertions.assertEquals(13, output);
    }

    @Test
    void solveInputA() {
        long output = new Day4().solveA(getInput("day4-input.txt"));
        Assertions.assertEquals(21105, output);
    }

    List<Day4Input> getInput(String file) {
        List<String> lines = TestUtil.readInput(file);
        List<Day4Input> input = new ArrayList<>();
        for (String line : lines) {
            Scanner scanner = new Scanner(line);
            scanner.next();
            scanner.next();

            List<Integer> winningNumbers = new ArrayList<>();
            while(scanner.hasNextInt()) winningNumbers.add(scanner.nextInt());
            scanner.next();
            List<Integer> myNumbers = new ArrayList<>();
            while(scanner.hasNextInt()) myNumbers.add(scanner.nextInt());

            input.add(new Day4Input(winningNumbers, myNumbers));
        }
        return input;
    }

//    @Test
//    void solveExampleB() {
//        int output = new Day3().solveB(TestUtil.readInput("day3-example.txt"));
//        Assertions.assertEquals(467835, output);
//    }
//
//    @Test
//    void solveInputB() {
//        int output = new Day3().solveB(TestUtil.readInput("day3-input.txt"));
//        Assertions.assertEquals(80403602, output);
//    }
}

