import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;

public class Day11 {
    public long solve(List<List<Character>> input, long distance) {
        Set<Integer> emptyRows = IntStream.range(0, input.size())
                .filter(r -> input.get(r).stream().allMatch(ch -> ch == '.'))
                .boxed().collect(toSet());
        Set<Integer> emptyColumns = IntStream.range(0, input.getFirst().size())
                .filter(c -> input.stream().map(characters -> characters.get(c)).allMatch(ch -> ch == '.'))
                .boxed().collect(toSet());

        var cells = new ArrayList<Cell>();

        long skippedRows = 0;
        for (int r = 0; r < input.size(); r++) {
            if (emptyRows.contains(r)) {
                skippedRows++; continue;
            }

            long skippedCols = 0;
            for (int c = 0; c < input.get(r).size(); c++) {
                if (emptyColumns.contains(c)) {
                    skippedCols++; continue;
                }

                if (input.get(r).get(c) == '#') {
                    cells.add(new Cell(r + skippedRows * distance, c + skippedCols * distance));
                }
            }
        }

        long output = 0;
        for (int i = 0; i < cells.size(); i++) {
            for (int j = i + 1; j < cells.size(); j++) {
                Cell cell1 = cells.get(i), cell2 = cells.get(j);
                output += Math.abs(cell1.r - cell2.r) + Math.abs(cell1.c - cell2.c);
            }
        }

        return output;
    }

    record Cell(long r, long c) {
    }
}
