package baseball.view;

import baseball.domain.GameHint;

import java.util.Map;

public class OutputView {
    public void printBegin(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printStatus(Map<GameHint, Integer> gameStatus){
        if(gameStatus.containsKey(GameHint.NOTHING)){
            System.out.println(GameHint.NOTHING.getKorean());
            return;
        }
        String convertedStatus = attach(GameHint.BALL, gameStatus.get(GameHint.BALL))
                + attach(GameHint.STRIKE, gameStatus.get(GameHint.STRIKE));
        System.out.println(convertedStatus.trim());
    }

    private String attach(GameHint gameHint, int count) {
        if (count != 0) {
            return count + gameHint.getKorean() + " ";
        }
        return " ";
    }
}
