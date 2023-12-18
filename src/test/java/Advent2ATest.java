import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Advent2ATest {
    @Test
    void solveExA() {
        int output = new Advent2A().solve(TestInput.readInput("advent2ex.txt"));
        Assertions.assertEquals(8, output);
    }

    @Test
    void solveInputA() {
        int output = new Advent2A().solve(TestInput.readInput("advent2input.txt"));
        Assertions.assertEquals(8, output);
    }
}

