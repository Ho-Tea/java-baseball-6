package baseball.domain;

import java.util.EnumMap;
import java.util.Map;

public enum GameHint {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private String korean;


    GameHint(String korean) {
        this.korean = korean;
    }

    public static Map<GameHint, Integer> of(int strikeCount, int ballCount){
        if(strikeCount == 0 && ballCount == 0){
            return new EnumMap<>(Map.of(NOTHING, 0));
        }
        return new EnumMap<>(Map.of(BALL, ballCount, STRIKE, strikeCount));
    }

    public String getKorean() {
        return korean;
    }
}
