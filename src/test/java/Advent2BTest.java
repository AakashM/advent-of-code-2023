import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Advent2BTest {
    @Test
    void solveExA() {
        int output = new Advent2B().solve(TestInput.readInput("advent2ex.txt"));
        Assertions.assertEquals(2286, output);
    }

    @Test
    void solveInputA() {
        int output = new Advent2B().solve(TestInput.readInput("advent2input.txt"));
        Assertions.assertEquals(58269, output);
    }
}

