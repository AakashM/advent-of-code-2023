import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Day5Test {
    @Test
    void solveExampleA() {
        long output = new Day5().solveA(getInput("day5-example.txt"));
        Assertions.assertEquals(35, output);
    }

    @Test
    void solveInputA() {
        long output = new Day5().solveA(getInput("day5-input.txt"));
        Assertions.assertEquals(174137457, output);
    }

    @Test
    void solveExampleB() {
        long output = new Day5().solveB(getInput("day5-example.txt"));
        Assertions.assertEquals(46, output);
    }

    @Test
    void solveInputB() {
        long output = new Day5().solveB(getInput("day5-input.txt"));
        Assertions.assertEquals(1493866, output);
    }

    Day5Input getInput(String file) {
        var scanner = TestUtil.getScanner(file);
        scanner.next();
        var seeds = new ArrayList<Long>();
        while (scanner.hasNextLong()) seeds.add(scanner.nextLong());

        var mappings = new ArrayList<Mapping>();
        while (scanner.hasNext()) {
            mappings.add(parseMapping(scanner));
        }

        var input = new Day5Input(seeds, mappings);
        System.out.println(input);
        return input;
    }

    private static Mapping parseMapping(Scanner scanner) {
        var mappingRanges = new ArrayList<MappingRange>();
        var name = scanner.next();
        scanner.next(); // skip "map:"
        while(scanner.hasNextLong()) {
            long destination = scanner.nextLong();
            long source = scanner.nextLong();
            long range = scanner.nextLong();
            mappingRanges.add(new MappingRange(source, destination, range));
        }

        var mapping = new Mapping(name, mappingRanges);
        return mapping;
    }
}


