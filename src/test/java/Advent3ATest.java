import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Advent3ATest {
    @Test
    void solveExA() {
        int output = new Advent3A().solve(TestInput.readInput("advent3ex.txt"));
        Assertions.assertEquals(4361, output);
    }

    @Test
    void solveInputA() {
        int output = new Advent3A().solve(TestInput.readInput("advent3input.txt"));
        Assertions.assertEquals(528819, output);
    }
}

