import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day3Test {
    @Test
    void solveExampleA() {
        int output = new Day3().solveA(TestUtil.readInput("day3-example.txt"));
        Assertions.assertEquals(4361, output);
    }

    @Test
    void solveInputA() {
        int output = new Day3().solveA(TestUtil.readInput("day3-input.txt"));
        Assertions.assertEquals(528819, output);
    }

    @Test
    void solveExampleB() {
        int output = new Day3().solveB(TestUtil.readInput("day3-example.txt"));
        Assertions.assertEquals(467835, output);
    }

    @Test
    void solveInputB() {
        int output = new Day3().solveB(TestUtil.readInput("day3-input.txt"));
        Assertions.assertEquals(80403602, output);
    }
}

