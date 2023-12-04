package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("^[1-9]*$");
    private static final String SEPARATOR = "";

    public List<Integer> inputNumbers() {
        System.out.println("숫자를 입력해주세요 : ");
        String numbers = Console.readLine();
        validateNullAndEmpty(numbers);
        validateNumeric(numbers);
        return Arrays.stream(numbers.split(SEPARATOR))
                .map(Integer::valueOf)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateNullAndEmpty(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new IllegalArgumentException("null 이거나 길이가 없는 문자열 입니다.");
        }
    }

    private void validateNumeric(String input) {
        if (!NUMERIC_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("문자열이 숫자 1부터 9까지로 이루어져 있지 않습니다.");
        }
    }
}
