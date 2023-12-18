import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Day1 {
    public int solveB(List<String> strings) {
        Map<String, Integer> numbers = Map.of(
                "one", 1,
                "two", 2,
                "three", 3,
                "four", 4,
                "five", 5,
                "six", 6,
                "seven", 7,
                "eight", 8,
                "nine", 9
        );


        int output = 0;
        for (String line : strings) {
            int firstNum = -1, lastNum = -1;
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c >= '0' && c <= '9') {
                    if (firstNum == -1) firstNum = c - '0';
                    lastNum = c - '0';
                } else {
                    int finalI = i;
                    Optional<String> numWord = numbers.keySet().stream()
                            .filter(s ->
                                    finalI + s.length() <= line.length()
                                            && s.equals(line.substring(finalI, finalI + s.length())))
                            .findFirst();
                    if (numWord.isPresent()) {
                        if (firstNum == -1) firstNum = numbers.get(numWord.get());
                        lastNum = numbers.get(numWord.get());
                    }
                }
            }
            output += firstNum * 10 + lastNum;
        }
        return output;
    }
}