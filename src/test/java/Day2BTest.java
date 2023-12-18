import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day2BTest {
    @Test
    void solveExA() {
        int output = new Day2B().solve(TestUtil.readInput("day2-example.txt"));
        Assertions.assertEquals(2286, output);
    }

    @Test
    void solveInputA() {
        int output = new Day2B().solve(TestUtil.readInput("day2-input.txt"));
        Assertions.assertEquals(58269, output);
    }
}

