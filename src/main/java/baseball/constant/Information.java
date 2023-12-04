package baseball.constant;

public enum Information {
    BEGIN_GAME("숫자 야구 게임을 시작합니다."),
    END_GAME("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    NUMBERS("숫자를 입력해주세요 : "),
    DECIDE_GAME("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    ;

    private String message;

    Information(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
