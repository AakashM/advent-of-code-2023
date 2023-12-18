import java.util.*;
import java.util.stream.IntStream;

public class Day4 {
    int[] cardCounts = new int[500];

    public long solveA(List<Card> cards) {
        long output = 0;
        for (Card card : cards) {
            int count = getWinningCount(card);
            if (count > 0) output += 1L << (count - 1);
//            System.out.println((1L << (count-1)) + " : " + output);
        }
        return output;
    }

    private int getWinningCount(Card card) {
        Set<Integer> winningNumbers = new HashSet<>(card.winningNumbers());
        int count = 0;
        for (Integer myNumber : card.myNumbers()) {
            if (winningNumbers.contains(myNumber)) count++;
        }
        return count;
    }

    public long solveB(List<Card> cards) {
        for (Card card : cards) cardCounts[card.cardNumber()] = 1;
        for (Card card : cards) {
            int count = getWinningCount(card);
            while (count > 0) {
                cardCounts[card.cardNumber() + count--] += cardCounts[card.cardNumber()];
            }
        }

        return IntStream.of(cardCounts).sum();
    }
}

record Card(Integer cardNumber, List<Integer> winningNumbers, List<Integer> myNumbers) {
}
