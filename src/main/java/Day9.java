import java.util.ArrayList;
import java.util.List;

public class Day9 {
    public long solveA(List<List<Integer>> input) {
        return input.stream().map(this::solveForNums).mapToInt(Integer::intValue).sum();
    }

    private Integer solveForNums(List<Integer> nums) {
        List<List<Integer>> allNums = new ArrayList<>();
        allNums.add(nums);

        while (allNums.getLast().stream().anyMatch(n -> n != 0)) {
            var newNums = new ArrayList<Integer>();
            for (int i = 1; i < allNums.getLast().size(); i++) {
                newNums.add(allNums.getLast().get(i) - allNums.getLast().get(i - 1));
            }
            allNums.add(newNums);
        }
        System.out.println(allNums);
        return allNums.stream().map(n -> n.getLast()).mapToInt(Integer::intValue).sum();
    }


}
