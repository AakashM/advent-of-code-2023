import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Day5 {

    private Day5Input input;

    public long solveA(Day5Input input) {
        this.input = input;
        return input.seeds().stream().mapToLong(this::getLocationForSeed).min().getAsLong();
    }

    long getLocationForSeed(long seed) {
        long number = seed;
        for (Mapping mapping : input.mappings()) {
            number = mapToNextNumber(mapping, number);
        }
        return number;
    }

    private long mapToNextNumber(Mapping mapping, long number) {
        for (MappingRange mappingRange : mapping.mappingRanges()) {
            long diff = number - mappingRange.source();
            if (diff >= 0 && diff < mappingRange.range()) {
                return mappingRange.destination() + diff;
            }
        }

        return number;
    }

    public long solveB(Day5Input input) {
        long output = 0;
        return output;
    }
}

record Day5Input(List<Long> seeds, List<Mapping> mappings) {
}

record Mapping(String name, List<MappingRange> mappingRanges) {
}

record MappingRange(long source, long destination, long range) {
}
