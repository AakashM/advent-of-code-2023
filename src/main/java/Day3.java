import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {
    Map<Gear, List<Integer>> gears = new HashMap<>();
    Pattern NUMBER_PATTERN = Pattern.compile("\\d+");

    public int solveA(List<String> strings) {
        int output = 0;
        for (int r = 0; r < strings.size(); r++) {
            String str = strings.get(r);
            Matcher matcher = NUMBER_PATTERN.matcher(str);

            while (matcher.find()) {
                if (!getAdjacentGears(r, matcher.start(), matcher.end() - 1, strings).isEmpty()) {
                    output += Integer.parseInt(matcher.group());

                    System.out.println(matcher.group());
                }
            }
        }

        return output;
    }

    private List<Gear> getAdjacentGears(int r, int start, int end, List<String> strings) {
        List<Gear> output = new ArrayList<>();
        var symbolPattern = Pattern.compile(".*?[^0-9.].*").pattern();
        String currentLine = strings.get(r);

        int beforeStart = Math.max(0, start - 1);
        int afterEnd = Math.min(currentLine.length() - 1, end + 1);
        if (start - 1 >= 0 && currentLine.substring(start - 1, start).matches(symbolPattern))
            output.add(new Gear(r, start-1));
        if (end + 1 < currentLine.length() && currentLine.substring(end + 1, end + 2).matches(symbolPattern))
            output.add(new Gear(r, end+1));
        if(r>0) {
            for(int c=beforeStart; c<=afterEnd; c++) {
                if(strings.get(r - 1).substring(c, c + 1).matches(symbolPattern))
                    output.add(new Gear(r-1, c));
            }
        }
        if(r<currentLine.length() - 1) {
            for(int c=beforeStart; c<=afterEnd; c++) {
                if(strings.get(r + 1).substring(c, c + 1).matches(symbolPattern))
                    output.add(new Gear(r+1, c));
            }
        }
        return output;
    }

    public int solveB(List<String> strings) {

        int output = 0;
        for (int r = 0; r < strings.size(); r++) {
            String str = strings.get(r);
            Matcher matcher = NUMBER_PATTERN.matcher(str);

            while (matcher.find()) {
                for (Gear gear : getAdjacentGears(r, matcher.start(), matcher.end() - 1, strings)) {
                    gears.putIfAbsent(gear, new ArrayList<>());
                    gears.get(gear).add(Integer.parseInt(matcher.group()));
                }
            }
        }

        for (List<Integer> nums : gears.values()) {
            if(nums.size()==2) {
                output += nums.get(0) * nums.get(1);
            }
        }

        return output;
    }
}

record Gear(int r, int c) {
}
