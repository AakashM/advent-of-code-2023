import com.google.common.primitives.Chars;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

public class Day11Test {

    @ParameterizedTest
    @CsvSource({
            "day11-example.txt,374",
            "day11-input.txt,10231178",

    })
    void solveA(String path, int expected) {
        long output = new Day11().solveA(getInput(path));
        Assertions.assertEquals(expected, output);
    }

//    @ParameterizedTest
//    @CsvSource({
//            "day11-exampleB1.txt,4",
//            "day11-exampleB2.txt,4",
//            "day11-exampleB3.txt,8",
//            "day11-exampleB4.txt,10",
//            "day11-input.txt,401"
//
//    })
//    void solveB(String path, int expected) {
//        long output = new Day11().solveB(getInput(path));
//        Assertions.assertEquals(expected, output);
//    }

    List<List<Character>> getInput(String file) {
        return TestUtil.readInput(file).stream()
                .map(str -> Chars.asList(str.toCharArray()))
                .toList();
    }
}


