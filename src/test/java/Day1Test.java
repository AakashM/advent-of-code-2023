import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day1Test {
    @Test
    void solveExampleB() {
        int output = new Day1().solveB(TestUtil.readInput("day1-example.txt"));
        Assertions.assertEquals(281, output);
    }

    @Test
    void solveInputB() {
        int output = new Day1().solveB(TestUtil.readInput("day1-input.txt"));
        Assertions.assertEquals(53868, output);
    }
}

