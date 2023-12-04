package baseball.domain;

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
                .orElseThrow(() -> new IllegalArgumentException("재시작/종료에 해당하는 숫자가 아닙니다."));
    }

}
