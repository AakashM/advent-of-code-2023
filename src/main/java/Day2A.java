import java.util.List;
import java.util.Map;

public class Day2A {
    Map<String, Integer> map = Map.of(
            "red", 12,
            "green", 13,
            "blue", 14
    );

    int solve(List<String> input) {
        int output = 0;
        int game = 1;
        for (String in : input) {
            output += solve(in, game++);
        }
        return output;
    }

    private int solve(String in, int game) {

        var draw = in.split(":")[1];
        for(String d: draw.split(";")) {
            d = d.trim();
            for(String ball: d.split(",")) {
                ball = ball.trim();
                int count = Integer.parseInt(ball.split(" ")[0]);
                var color = ball.split(" ")[1];

                if(map.get(color) < count) return 0;
            }

        }

        return game;
    }
}
