package baseball.domain;

public enum GameHint {
    STRIKE("스트라이크", "%d"),
    BALL("볼", "%d"),
    NOTHING("낫싱", "");

    private String korean;
    private String count;


    GameHint(String korean, String count) {
        this.korean = korean;
        this.count = count;
    }
}
