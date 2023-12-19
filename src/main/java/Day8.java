import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class Day8 {
        ConcurrentMap<String, Node> nextNodes = new ConcurrentHashMap<>();
    public long solveA(Day8Input input) {
        Node current = input.nodes.get("AAA");

        long count = 0;
//        while (true) {
            initNeztZNode(current, input.directions());
            count += current.distanceToNextZNode;
//            current = current.nextZNode;
//            System.out.println(current.name);
//            if (current.getName().equals("ZZZ")) break;
//        }
        return count * input.directions().length();
    }

    public long solveB(Day8Input input) {
        List<Node> currentNodes = input.nodes.values().stream().filter(n -> n.getName().charAt(2) == 'A').toList();
        System.out.println(currentNodes.stream().map(Node::getName).collect(Collectors.joining(",")));

        PriorityQueue<Path> paths = new PriorityQueue<>(currentNodes.stream().map(n -> new Path(0, n)).toList());

        while (true) {
            Path path = paths.remove();
            initNeztZNode(path.currentNode, input.directions());
            path.distanceCovered += path.currentNode.distanceToNextZNode;
            path.currentNode = path.currentNode.nextZNode;

            paths.add(path);

            if(paths.stream().allMatch(p -> p.distanceCovered == paths.peek().distanceCovered)) break;
        }

        return paths.remove().distanceCovered * input.directions().length();

//        var jumps = currentNodes.parallelStream().map(n -> getJumpCount(n, input.directions())).toList();
//        System.out.println(jumps);
//        int count = 0;
//        while (true) {
//            count += input.directions().length();
//            currentNodes = currentNodes.parallelStream().map(n -> getNextNode(n, input.directions())).toList();
//            if (currentNodes.stream().allMatch(n -> n.getName().charAt(2) == 'Z')) break;
//        }
//        return 0;
    }

//    long getJumpCount(Node n, String directions) {
//        long count = 0;
//        while (n.getName().charAt(2) != 'Z') {
//            initNeztZNode(n);
//            n = getNextZNode(n, directions);
//            count++;
//        }
//        return count;
//    }

    private void initNeztZNode(Node n, String directions) {
        if (n.nextZNode != null) return;
        long count = 0;
        var currentNode = n;
        do {
            currentNode = getNextZNode(currentNode, directions);
            count++;
        } while (currentNode.name.charAt(2) != 'Z');

        n.nextZNode = currentNode;
        n.distanceToNextZNode = count;
    }

    Node getNextZNode(Node n, String directions) {
        if (nextNodes.containsKey(n.getName())) return nextNodes.get(n.getName());

        var currentNode = n;
        for (char ch : directions.toCharArray()) {
            currentNode = ch == 'L' ? currentNode.getLeft() : currentNode.getRight();
        }

        nextNodes.put(n.getName(), currentNode);
        return currentNode;
    }

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    @NoArgsConstructor
    static class Node {
        String name;
        Node left;
        Node right;
        Node nextZNode;
        long distanceToNextZNode;
    }

    record Day8Input(String directions, Map<String, Node> nodes) {
    }

    @Data
    @AllArgsConstructor
    class Path implements Comparable<Path> {
        long distanceCovered;
        Node currentNode;
        @Override
        public int compareTo(Path o) {
            return Long.compare(distanceCovered, o.distanceCovered);
        }
    }
}


