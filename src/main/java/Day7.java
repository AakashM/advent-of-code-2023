import com.google.common.collect.Streams;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day7 {
    private boolean isJoker = false;
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
                .filter(c -> !(isJoker && c=='J'))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Long> frequencies = frequencyMap.values().stream().sorted().toList().reversed();
        frequencies = new ArrayList<>(frequencies);
        if(isJoker) {
            long countOfJokers = hand.cards().chars().mapToObj(value -> (char) value).filter(c->c=='J').count();
            if(frequencies.size() > 0) {
                frequencies.set(0, frequencies.get(0)+countOfJokers);
            } else {
                frequencies.add(countOfJokers);
            }
        }
        int PRIORITY = 1100;
        if (frequencies.get(0) == 5) {
            return PRIORITY + 9;
        } else if (frequencies.get(0) == 4) {
            return PRIORITY + 8;
        } else if (frequencies.get(0) == 3 && frequencies.get(1) == 2) {
            return PRIORITY + 7;
        } else if (frequencies.get(0) == 3) {
            return PRIORITY + 6;
        } else if (frequencies.get(0) == 2 && frequencies.get(1) == 2) {
            return PRIORITY + 5;
        } else if (frequencies.get(0) == 2) {
            return PRIORITY + 4;
        } else if (frequencies.get(0) == 1) {
            return PRIORITY + 3;
        } else {
            throw new RuntimeException("Should not reach here");
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
        if (isJoker && c == 'J') return -1;
        return cardComparisonValues.get(c);
    }

    public long solveB(List<Hand> hands) {
        isJoker = true;
        return solveA(hands);
    }

    record Hand(String cards, int bid) {
    }

}


