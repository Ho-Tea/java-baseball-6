package baseball.controller;

import baseball.domain.*;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Map;

public class Game {
    private final InputView inputView;
    private final OutputView outputView;

    public Game(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        outputView.printBegin();
        do {
            play(new Computer(new BaseballNumber(BaseballNumberGenerator.generate())));
            outputView.printEnd();
        } while (GameDecision.match(inputView.inputDecideNumber()).equals(GameDecision.RESTART));

    }

    private void play(Computer computer) {
        Map<GameHint, Integer> gameStatus = computer.compare(new BaseballNumber(inputView.inputNumbers()));
        outputView.printStatus(gameStatus);
        if (!computer.lose(gameStatus)) {
            play(computer);
        }
    }

}
