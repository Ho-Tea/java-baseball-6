package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameNumber {
    private final List<Integer> numbers;

    public GameNumber(List<Integer> numbers) {
        validateRange(numbers);
        validateDuplicate(numbers);
        validateSize(numbers);
        this.numbers = numbers;
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 9) {
                throw new IllegalArgumentException("숫자는 1에서 9까지의 수로 이루어져야 합니다.");
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if(distinctNumbers.size() != numbers.size()){
            throw new IllegalArgumentException("숫자는 서로 다른 수로 이루어져야 합니다.");
        }
    }

    private void validateSize(List<Integer> numbers) {
        if(numbers.size() != 3){
            throw new IllegalArgumentException("숫자의 개수는 3개로 이루어져야 합니다.");
        }
    }
}
