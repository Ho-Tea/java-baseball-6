package baseball.view;

import baseball.constant.Information;
import baseball.domain.GameHint;

import java.util.Map;

public class OutputView {
    private final static String DELIMITER = " ";

    public void printBegin() {
        System.out.println(Information.BEGIN_GAME.getMessage());
    }

    public void printEnd() {
        System.out.println(Information.END_GAME.getMessage());
    }

    public void printStatus(Map<GameHint, Integer> gameStatus) {
        if (gameStatus.containsKey(GameHint.NOTHING)) {
            System.out.println(GameHint.NOTHING.getKorean());
            return;
        }
        String convertedStatus = attach(GameHint.BALL, gameStatus.get(GameHint.BALL))
                + attach(GameHint.STRIKE, gameStatus.get(GameHint.STRIKE));
        System.out.println(convertedStatus.trim());
    }

    private String attach(GameHint gameHint, int count) {
        if (count != 0) {
            return count + gameHint.getKorean() + DELIMITER;
        }
        return DELIMITER;
    }
}
