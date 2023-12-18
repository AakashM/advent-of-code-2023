import java.util.List;

public class Day2B {
    int solve(List<String> input) {
        int output = 0;
        int game = 1;
        for (String in : input) {
            output += solve(in, game++);
        }
        return output;
    }

    private int solve(String in, int game) {
        int red = 0, blue = 0, green = 0;

        var draw = in.split(":")[1];
        for (String d : draw.split(";")) {
            d = d.trim();
            for (String ball : d.split(",")) {
                ball = ball.trim();
                int count = Integer.parseInt(ball.split(" ")[0]);
                var color = ball.split(" ")[1];

                switch (color) {
                    case "red" -> red = Math.max(red, count);
                    case "blue" -> blue = Math.max(blue, count);
                    case "green" -> green = Math.max(green, count);
                }
            }

        }

        return red * blue * green;
    }
}
