import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Advent3ATest {
    @Test
    void solveExampleA() {
        int output = new Advent3A().solveA(TestInput.readInput("advent3ex.txt"));
        Assertions.assertEquals(4361, output);
    }

    @Test
    void solveInputA() {
        int output = new Advent3A().solveA(TestInput.readInput("advent3input.txt"));
        Assertions.assertEquals(528819, output);
    }

    @Test
    void solveExampleB() {
        int output = new Advent3A().solveB(TestInput.readInput("advent3ex.txt"));
        Assertions.assertEquals(467835, output);
    }

    @Test
    void solveInputB() {
        int output = new Advent3A().solveB(TestInput.readInput("advent3input.txt"));
        Assertions.assertEquals(80403602, output);
    }
}

