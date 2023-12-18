import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day3ATest {
    @Test
    void solveExampleA() {
        int output = new Day3A().solveA(TestInput.readInput("day3example.txt"));
        Assertions.assertEquals(4361, output);
    }

    @Test
    void solveInputA() {
        int output = new Day3A().solveA(TestInput.readInput("day3input.txt"));
        Assertions.assertEquals(528819, output);
    }

    @Test
    void solveExampleB() {
        int output = new Day3A().solveB(TestInput.readInput("day3example.txt"));
        Assertions.assertEquals(467835, output);
    }

    @Test
    void solveInputB() {
        int output = new Day3A().solveB(TestInput.readInput("day3input.txt"));
        Assertions.assertEquals(80403602, output);
    }
}

