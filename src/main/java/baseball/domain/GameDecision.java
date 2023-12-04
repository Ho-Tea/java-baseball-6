package baseball.domain;

import baseball.constant.Exception;

import java.util.Arrays;

public enum GameDecision {
    RESTART(1),
    QUIT(2);

    private final int decisionNumber;

    GameDecision(int decisionNumber) {
        this.decisionNumber = decisionNumber;
    }

    public static GameDecision match(int number) {
        return Arrays.stream(GameDecision.values())
                .filter(status -> status.decisionNumber == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(Exception.DECIDE_NUMBER.getMessage()));
    }

}
