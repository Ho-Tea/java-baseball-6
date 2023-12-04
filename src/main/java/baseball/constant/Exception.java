package baseball.constant;

public enum Exception {
    NULL_OR_EMPTY("null 이거나 길이가 없는 문자열 입니다."),
    NUMERIC("문자열이 숫자 1부터 9까지로 이루어져 있지 않습니다."),
    SINGLE_LETTER("문자열의 크기는 한개로 이루어져야 합니다."),
    DECIDE_NUMBER("재시작/종료에 해당하는 숫자가 아닙니다."),
    NUMBER_RANGE("숫자는 1에서 9까지의 수로 이루어져야 합니다."),
    NUMBER_DUPLICATE("숫자는 서로 다른 수로 이루어져야 합니다."),
    NUMBER_SIZE("숫자의 개수는 3개로 이루어져야 합니다."),
    ;


    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
