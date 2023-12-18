import java.util.List;

public class Day6 {
    public long solveA(List<Race> races) {
        return races.stream().map(this::getCombinationsForRace).reduce(1L, (n1, n2) -> n1 * n2);
    }

    long getCombinationsForRace(Race race) {
        int output = 0;
        for (int chargeTime = 0; chargeTime <= race.time(); chargeTime++) {
            int speed = chargeTime;
            long remainingTime = race.time() - chargeTime;
            long distanceCovered = speed * remainingTime;
            if(distanceCovered > race.distance()) output++;
        }
        return output;
    }

    public long solveB(Race race) {
        return getCombinationsForRace(race);
    }
}

record Race(long time, long distance) {
}
