package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameNumber {
    private final List<Integer> numbers;

    public GameNumber(List<Integer> numbers) {
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 9) {
                throw new IllegalArgumentException("숫자는 1에서 9까지의 수로 이루어져야 합니다.");
            }
        }
    }
}
