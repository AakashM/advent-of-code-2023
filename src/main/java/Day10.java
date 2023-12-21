import java.util.*;

import static java.lang.StringTemplate.STR;

public class Day10 {
    int[][] DIRECTIONS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    int[] outToInDirMap = {1, 0, 3, 2};

    public long solveA(List<List<Cell>> input) {
//        Map<RC, Cell> map = input.stream().flatMap(Collection::stream).collect(toMap(cell -> new RC(cell.row, cell.col), cell -> cell));

        Cell startCell = findStart(input);

        Queue<Cell> q = new ArrayDeque<>();
        q.add(startCell);

        Set<Cell> visited = new HashSet<>();
        visited.add(startCell);

        long count = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- > 0) {
                Cell cell = q.remove();
                boolean[] allowedDirs = {cell.left, cell.right, cell.up, cell.down};
                for (int i = 0; i < 4; i++) {
                    if (!allowedDirs[i]) continue;
                    addIfValidDirection(input, DIRECTIONS[i], cell, q, visited, i);
                }
            }
            count++;

            System.out.println(q);
            if (q.size() < 2) break;
        }

        return count;
    }

    private void addIfValidDirection(List<List<Cell>> input, int[] direction, Cell startCell, Queue<Cell> q, Set<Cell> visited, int outDir) {
        int newRow = startCell.row + direction[0];
        int newCol = startCell.col + direction[1];
        if (newRow >= 0 && newRow < input.size() && newCol >= 0 && newCol < input.getFirst().size()) {
            Cell nextCell = input.get(newRow).get(newCol);
            if (nextCell.ch!='.' && !visited.contains(nextCell)) {
                boolean[] nextCellAllowedDirs = {nextCell.left, nextCell.right, nextCell.up, nextCell.down};
                if (outDir == -1 || nextCellAllowedDirs[outToInDirMap[outDir]]) {
                    visited.add(nextCell);
                    q.add(nextCell);
                }
            }
        }
    }

    Cell findStart(List<List<Cell>> input) {
        return input.stream().flatMap(Collection::stream).filter(c -> c.ch == 'S').findFirst().get();
    }

    record Cell(int row, int col, boolean left, boolean right, boolean up, boolean down, char ch) {
        @Override
        public String toString() {
            return STR."\{row},\{col},\{ch}";
        }
    }
}
