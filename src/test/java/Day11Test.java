import com.google.common.primitives.Chars;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

public class Day11Test {
    @ParameterizedTest
    @CsvSource({
            "day11-example.txt, 2,      374",
            "day11-example.txt, 10,     1030",
            "day11-example.txt, 100,    8410",
            "day11-input.txt,   2,      10231178",
            "day11-input.txt,   1000000,622120986954",
    })
    void solve(String path, int distance, long expected) {
        long output = new Day11().solve(getInput(path), distance - 1);
        Assertions.assertEquals(expected, output);
    }

    List<List<Character>> getInput(String file) {
        return TestUtil.readInput(file).stream()
                .map(str -> Chars.asList(str.toCharArray()))
                .toList();
    }
}


