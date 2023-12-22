import java.util.*;

public class Day10 {
    int LEFT = 0, RIGHT = 1, UP = 2, DOWN = 3;
    int[][] DIRECTIONS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; // LEFT, RIGHT, TOP, DOWN
    int[] outToInDirMap = {1, 0, 3, 2};
    Set<Cell> visited;
    Character startCharacter;

    public long solveA(List<List<Cell>> input) {
//        Map<RC, Cell> map = input.stream().flatMap(Collection::stream).collect(toMap(cell -> new RC(cell.row, cell.col), cell -> cell));

        Cell startCell = findStart(input);

        Queue<Cell> q = new ArrayDeque<>();
        q.add(startCell);

        visited = new HashSet<>();
        visited.add(startCell);

        long count = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- > 0) {
                Cell cell = q.remove();
                boolean[] allowedDirs = {cell.left, cell.right, cell.up, cell.down};
                Set<Integer> directions = new HashSet<>();
                for (int i = 0; i < 4; i++) {
                    if (!allowedDirs[i]) continue;
                    boolean valid = addIfValidDirection(input, DIRECTIONS[i], cell, q, visited, i);
                    if (valid) directions.add(i);
                }

                if (cell.ch == 'S') {
                    if (directions.contains(LEFT) && directions.contains(RIGHT)) startCharacter = '-';
                    else if (directions.contains(UP) && directions.contains(DOWN)) startCharacter = '|';
                    else if (directions.contains(RIGHT) && directions.contains(DOWN)) startCharacter = 'F';
                    else if (directions.contains(LEFT) && directions.contains(DOWN)) startCharacter = '7';
                    else if (directions.contains(UP) && directions.contains(RIGHT)) startCharacter = 'L';
                    else if (directions.contains(LEFT) && directions.contains(UP)) startCharacter = 'J';
                    else throw new RuntimeException("Should not reach here");
                }
            }
            count++;
        }

        return count - 1;
    }

    private boolean addIfValidDirection(List<List<Cell>> input, int[] direction, Cell currentCell, Queue<Cell> q, Set<Cell> visited, int outDir) {
        int newRow = currentCell.row + direction[0];
        int newCol = currentCell.col + direction[1];
        if (newRow >= 0 && newRow < input.size() && newCol >= 0 && newCol < input.getFirst().size()) {
            Cell nextCell = input.get(newRow).get(newCol);
            if (nextCell.ch != '.' && !visited.contains(nextCell)) {
                boolean[] nextCellAllowedDirs = {nextCell.left, nextCell.right, nextCell.up, nextCell.down};
                if (nextCellAllowedDirs[outToInDirMap[outDir]]) {
                    visited.add(nextCell);
                    q.add(nextCell);
                    return true;
                }
            }
        }
        return false;
    }

    Cell findStart(List<List<Cell>> input) {
        return input.stream().flatMap(Collection::stream).filter(c -> c.ch == 'S').findFirst().get();
    }

    Map<Character, List<Character>> endMap = Map.of(
            'F', List.of('7', 'J'),
            'L', List.of('J', '7')
    );

    public long solveB(List<List<Cell>> cells) {
        solveA(cells);
        long output = 0;
        for (List<Cell> row : cells) {
            boolean inRegion = false;
            boolean inWall = false;
            char wallStart = 'a';
            for (Cell cell : row) {
                char ch = cell.ch;
                if(ch=='S') ch = startCharacter;
                if (inWall) { // In wall
                    if (ch == endMap.get(wallStart).get(0)) {
                        inWall = false;
                    } else if (ch == endMap.get(wallStart).get(1)) {
                        inWall = false; inRegion = !inRegion;
                    } else if (ch != '-') {
                        System.out.println(row);
                        throw new RuntimeException("Should not reach here");
                    }
                } else if (visited.contains(cell)) { // Outside region and outside wall
                    if (ch == '|') {
                        inRegion = !inRegion;
                    } else if (ch == 'F' || ch == 'L') {
                        inWall = true; wallStart = ch;
                    }
                } else {
                    if (inRegion) output++;
                }
            }
        }
        return output;
    }

    record Cell(int row, int col, boolean left, boolean right, boolean up, boolean down, char ch) {
        @Override
        public String toString() {
            return STR."\{row},\{col},\{ch}";
        }
    }
}
