import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day2ATest {
    @Test
    void solveExA() {
        int output = new Day2A().solve(TestUtil.readInput("day2-example.txt"));
        Assertions.assertEquals(8, output);
    }

    @Test
    void solveInputA() {
        int output = new Day2A().solve(TestUtil.readInput("day2-input.txt"));
        Assertions.assertEquals(2101, output);
    }
}

