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

    List<Card> getInput(String file) {
        List<String> lines = TestUtil.readInput(file);
        List<Card> input = new ArrayList<>();
        int cardNumber = 1;
        for (String line : lines) {
            Scanner scanner = new Scanner(line);
            scanner.next();
            scanner.next();

            List<Integer> winningNumbers = new ArrayList<>();
            while(scanner.hasNextInt()) winningNumbers.add(scanner.nextInt());
            scanner.next();
            List<Integer> myNumbers = new ArrayList<>();
            while(scanner.hasNextInt()) myNumbers.add(scanner.nextInt());

            input.add(new Card(cardNumber++, winningNumbers, myNumbers));
        }
        return input;
    }

    @Test
    void solveExampleB() {
        long output = new Day4().solveB(getInput("day4-example.txt"));
        Assertions.assertEquals(30, output);
    }

    @Test
    void solveInputB() {
        long output = new Day4().solveB(getInput("day4-input.txt"));
        Assertions.assertEquals(5329815, output);
    }
}

