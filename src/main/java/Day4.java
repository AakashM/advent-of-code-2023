import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day4 {
    public long solveA(List<Day4Input> cards) {
        long output = 0;
        for (Day4Input card : cards) {
            Set<Integer> winningNumbers = new HashSet<>(card.winningNumbers());
            int count = 0;
            for (Integer myNumber : card.myNumbers()) {
                if (winningNumbers.contains(myNumber)) count++;
            }
            if(count>0) output += 1L << (count-1);
//            System.out.println((1L << (count-1)) + " : " + output);
        }
        return output;
    }
}

record Day4Input(List<Integer> winningNumbers, List<Integer> myNumbers) {
}
