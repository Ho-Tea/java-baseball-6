package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumberTest {

    @Test
    @DisplayName("1에서 9까지의 숫자가 아니라면 예외가 발생한다.")
    void validateRange() {
        assertThatThrownBy(() -> new BaseballNumber(List.of(0, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자는 1에서 9까지의 수로 이루어져야 합니다.");

    }

    @Test
    @DisplayName("중복된 숫자가 존재하면 예외가 발생한다.")
    void validateDuplicate() {
        assertThatThrownBy(() -> new BaseballNumber(List.of(2, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자는 서로 다른 수로 이루어져야 합니다.");

    }

    @Test
    @DisplayName("숫자의 개수가 3개가 아니라면 예외가 발생한다.")
    void validateSize() {
        assertThatThrownBy(() -> new BaseballNumber(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자의 개수는 3개로 이루어져야 합니다.");

    }

    @Test
    @DisplayName("방어적 복사를 사용할 시 내부의 값을 변경할 수 없다.")
    void defensiveCopy() {
        List<Integer> original = Arrays.asList(1,2,3);
        BaseballNumber baseballNumber = new BaseballNumber(original);
        BaseballNumber target = new BaseballNumber(List.of(1,2,4));
        original.set(2, 4);
        assertThat(baseballNumber.equals(target)).isFalse();
    }


    @ParameterizedTest
    @MethodSource("matchData")
    @DisplayName("다른 숫자와 비교해 같은 자리에 같은 수가 몇개 있는지 알 수 있다.")
    void matchCount(BaseballNumber computerNumber, BaseballNumber userNumber, int expected){
        assertThat(computerNumber.matchCount(userNumber)).isEqualTo(expected);
    }

    static Stream<Arguments> matchData() {
        BaseballNumber computerNumber = new BaseballNumber(List.of(4, 2, 3));
        return Stream.of(
                Arguments.of(computerNumber, new BaseballNumber(List.of(4, 2, 3)), 3),
                Arguments.of(computerNumber, new BaseballNumber(List.of(1, 2, 3)), 2),
                Arguments.of(computerNumber, new BaseballNumber(List.of(4, 3, 2)), 1),
                Arguments.of(computerNumber, new BaseballNumber(List.of(3, 4, 5)), 0)
        );
    }
}