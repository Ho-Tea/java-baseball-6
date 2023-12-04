package baseball;

import baseball.controller.Game;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        new Game(new InputView(), new OutputView()).start();
    }
}
