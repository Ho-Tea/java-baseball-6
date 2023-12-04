package baseball.view;

import baseball.constant.Exception;
import baseball.constant.Information;
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
        System.out.println(Information.NUMBERS.getMessage());
        String numbers = Console.readLine();
        validateNullAndEmpty(numbers);
        validateNumeric(numbers);
        return Arrays.stream(numbers.split(SEPARATOR))
                .map(Integer::valueOf)
                .collect(Collectors.toUnmodifiableList());
    }

    public int inputDecideNumber() {
        System.out.println(Information.DECIDE_GAME.getMessage());
        String decisionNumber = Console.readLine();
        validateNullAndEmpty(decisionNumber);
        validateNumeric(decisionNumber);
        validateSingleLetter(decisionNumber);
        return Integer.parseInt(decisionNumber);
    }

    private void validateNullAndEmpty(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new IllegalArgumentException(Exception.NULL_OR_EMPTY.getMessage());
        }
    }

    private void validateNumeric(String input) {
        if (!NUMERIC_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(Exception.NUMERIC.getMessage());
        }
    }
    private void validateSingleLetter(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException(Exception.SINGLE_LETTER.getMessage());
        }
    }
}
