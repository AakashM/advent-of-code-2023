import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.google.common.collect.Streams.mapWithIndex;

public class Day10Test {

    @Test
    void solveExampleA() {
        long output = new Day10().solveA(getInput("day10-example.txt"));
        Assertions.assertEquals(4, output);
    }

    @Test
    void solveExampleA2() {
        long output = new Day10().solveA(getInput("day10-example2.txt"));
        Assertions.assertEquals(8, output);
    }

    @Test
    void solveInputA() {
        long output = new Day10().solveA(getInput("day10-input.txt"));
        Assertions.assertEquals(7066, output);
    }

//    @Test
//    void solveExampleB() {
//        long output = new Day10().solveB(getInput("day10-example.txt"));
//        Assertions.assertEquals(2, output);
//    }
//
//    @Test
//    void solveInputB() {
//        long output = new Day10().solveB(getInput("day10-input.txt"));
//        Assertions.assertEquals(908, output);
//    }

    List<List<Day10.Cell>> getInput(String file) {
        return mapWithIndex(
                TestUtil.readLineStream(file),
                (line, row) -> mapWithIndex(
                        line.chars().mapToObj(val -> (char) val),
                        (ch, col) -> getCell(ch, row, col)).toList())
                .toList();
    }

    Day10.Cell getCell(Character ch, long row, long col) {
        boolean left = false, right = false, up = false, down = false;
        switch (ch) {
            case '-' -> left = right = true;
            case 'F' -> right = down = true;
            case '7' -> left = down = true;
            case '|' -> up = down = true;
            case 'L' -> up = right = true;
            case 'J' -> left = up = true;
            case 'S' -> left = right = up = down = true;
        }

        return new Day10.Cell((int) row, (int) col, left, right, up, down, ch);
    }
}


