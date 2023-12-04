package baseball.domain;

import java.util.Map;

public class Computer {
    private final BaseballNumber baseballNumber;

    public Computer(BaseballNumber baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public Map<GameHint, Integer> compare(BaseballNumber userBaseballNumber){
        int strikeCount = baseballNumber.matchCount(userBaseballNumber);
        int ballCount = baseballNumber.containsCount(userBaseballNumber) - strikeCount;
        return GameHint.of(strikeCount, ballCount);
    }

}
