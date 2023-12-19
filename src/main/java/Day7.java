import com.google.common.collect.Streams;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day7 {
    static Map<Character, Integer> cardComparisonValues = Map.ofEntries(
            new SimpleEntry<>('2', 2),
            new SimpleEntry<>('3', 3),
            new SimpleEntry<>('4', 4),
            new SimpleEntry<>('5', 5),
            new SimpleEntry<>('6', 6),
            new SimpleEntry<>('7', 7),
            new SimpleEntry<>('8', 8),
            new SimpleEntry<>('9', 9),
            new SimpleEntry<>('T', 10),
            new SimpleEntry<>('J', 11),
            new SimpleEntry<>('Q', 12),
            new SimpleEntry<>('K', 13),
            new SimpleEntry<>('A', 14)
    );

    public long solveA(List<Hand> hands) {
        List<Hand> sortedHands = hands.stream()
                .sorted(Comparator.comparing(this::getHandComparisonValue).thenComparing(this::getHandOneByOneComparisonValue))
                .toList();
        return Streams
                .mapWithIndex(sortedHands.stream(), (o, index) -> o.bid() * (index + 1))
                .mapToLong(Long::longValue)
                .sum();
    }

    Integer getHandComparisonValue(Hand hand) {
        Map<Character, Long> frequencyMap = hand.cards().chars()
                .mapToObj(value -> (char) value)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Long> frequencies = frequencyMap.values().stream().sorted().toList().reversed();
        if (frequencies.get(0) == 5) {
            return 100;
        } else if (frequencies.get(0) == 4) {
            return 99;
        } else if (frequencies.get(0) == 3 && frequencies.get(1) == 2) {
            return 98;
        } else if (frequencies.get(0) == 3) {
            return 97;
        } else if (frequencies.get(0) == 2 && frequencies.get(1) == 2) {
            return 96;
        } else if (frequencies.get(0) == 2) {
            return 95;
        } else {
            return hand.cards().chars()
                    .mapToObj(value -> (char) value)
                    .map(this::getCardComparisonValue)
                    .mapToInt(Integer::intValue)
                    .max().getAsInt();
        }
    }

    Integer getHandOneByOneComparisonValue(Hand hand1, Hand hand2) {
        var handComparator = Comparator.comparing(this::getCardComparisonValue);
        for (int i = 0; i < hand1.cards().length(); i++) {

            var compareResult = handComparator.compare(hand1.cards().charAt(i), hand2.cards().charAt(i));
            if (compareResult != 0) {
                return compareResult;
            }
        }
        throw new RuntimeException("Should not come here!");
    }

    Integer getCardComparisonValue(char c) {
        return cardComparisonValues.get(c);
    }

    record Hand(String cards, int bid) {
    }

}


