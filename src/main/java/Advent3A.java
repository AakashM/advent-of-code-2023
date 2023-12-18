import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Advent3A {
    public int solve(List<String> strings) {
        Pattern pattern = Pattern.compile("\\d+");

        int output = 0;
        for (int i = 0; i < strings.size(); i++) {
            String str = strings.get(i);
            Matcher matcher = pattern.matcher(str);

            while (matcher.find()) {
                if (isAdjacentToSymbol(i, matcher.start(), matcher.end() - 1, strings)) {
                    output += Integer.parseInt(matcher.group());

                    System.out.println(matcher.group());
//                    System.out.println(matcher.start());
//                    System.out.println(matcher.end());
                }
            }
        }

        return output;
    }

    private boolean isAdjacentToSymbol(int idx, int start, int end, List<String> strings) {
        var symbolPat = Pattern.compile(".*?[^0-9.].*").pattern();
        String currentLine = strings.get(idx);
        int beforeStart = Math.max(0, start - 1);
        int afterEnd = Math.min(currentLine.length() - 1, end + 1);
        return ((start - 1 >= 0 && currentLine.substring(start - 1, start).matches(symbolPat))
                || (end + 1 < currentLine.length() && currentLine.substring(end + 1, end + 2).matches(symbolPat))
                || idx > 0 && strings.get(idx - 1).substring(beforeStart, afterEnd + 1).matches(symbolPat)
                || idx < currentLine.length() - 1 && strings.get(idx + 1).substring(beforeStart, afterEnd + 1).matches(symbolPat)
        );
    }
}
