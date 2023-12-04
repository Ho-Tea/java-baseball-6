package baseball.domain;

import java.util.Arrays;

public enum GameDecision {
    RESTART(1),
    QUIT(2);

    private final int decisionNumber;

    GameDecision(int decisionNumber) {
        this.decisionNumber = decisionNumber;
    }


}
