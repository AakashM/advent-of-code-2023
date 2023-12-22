import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static com.google.common.collect.Streams.mapWithIndex;

public class Day10Test {

    @ParameterizedTest
    @CsvSource({
            "day10-example.txt,4",
            "day10-example2.txt,8",
            "day10-input.txt,7066"

    })
    void solveA(String path, int expected) {
        long output = new Day10().solveA(getInput(path));
        Assertions.assertEquals(expected, output);
    }

    @ParameterizedTest
    @CsvSource({
            "day10-exampleB1.txt,4",
            "day10-exampleB2.txt,4",
            "day10-exampleB3.txt,8",
            "day10-exampleB4.txt,10",
            "day10-input.txt,401"

    })
    void solveB(String path, int expected) {
        long output = new Day10().solveB(getInput(path));
        Assertions.assertEquals(expected, output);
    }

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
            case '|' -> up = down = true;
            case 'F' -> right = down = true;
            case '7' -> left = down = true;
            case 'L' -> up = right = true;
            case 'J' -> left = up = true;
            case 'S' -> left = right = up = down = true;
        }

        return new Day10.Cell((int) row, (int) col, left, right, up, down, ch);
    }
}


