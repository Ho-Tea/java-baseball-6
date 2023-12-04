package baseball.domain;

import java.util.*;

public class BaseballNumber {
    private final List<Integer> numbers;

    public BaseballNumber(List<Integer> numbers) {
        validateRange(numbers);
        validateDuplicate(numbers);
        validateSize(numbers);
        this.numbers = new ArrayList<>(numbers);
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
        if (distinctNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("숫자는 서로 다른 수로 이루어져야 합니다.");
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("숫자의 개수는 3개로 이루어져야 합니다.");
        }
    }

    public int matchCount(BaseballNumber baseballNumber) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (numbers.get(i).equals(baseballNumber.numbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    public int containsCount(BaseballNumber baseballNumber) {
        return (int) numbers.stream()
                .filter(number -> baseballNumber.numbers.contains(number))
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballNumber that = (BaseballNumber) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
