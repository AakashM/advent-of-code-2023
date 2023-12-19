import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day8Test {
    @Test
    void solveExampleA() {
        long output = new Day8().solveA(getInput("day8-example.txt"));
        Assertions.assertEquals(2, output);
    }

    @Test
    void solveInputA() {
        long output = new Day8().solveA(getInput("day8-input.txt"));
        Assertions.assertEquals(12599, output);
    }

    @Test
    void solveExampleB() {
        long output = new Day8().solveB(getInput("day8-exampleB.txt"));
        Assertions.assertEquals(6, output);
    }

    @Test
    void solveInputB() {
        long output = new Day8().solveB(getInput("day8-input.txt"));
        Assertions.assertEquals(8245452805243L, output);
    }

    Map<String, Day8.Node> nodeMap = new HashMap<>();

    Day8.Day8Input getInput(String file) {
        var lines = TestUtil.readInput(file);
        String directions = lines.get(0);

        lines.stream().skip(2).forEach(line -> {
            String name = line.substring(0, 3);
            var node = getNode(name);
            node.setLeft(getNode(line.substring(7, 10)));
            node.setRight(getNode(line.substring(12, 15)));
        });

        return new Day8.Day8Input(directions, nodeMap);
    }

    Day8.Node getNode(String name) {
        if (nodeMap.containsKey(name)) return nodeMap.get(name);

        Day8.Node node = new Day8.Node();
        node.setName(name);
        nodeMap.put(name, node);
        return node;
    }
}


