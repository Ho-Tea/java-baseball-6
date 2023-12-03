package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameNumberTest {

    @Test
    @DisplayName("1에서 9까지의 숫자가 아니라면 예외가 발생한다.")
    void validateRange() {
        assertThatThrownBy(() -> new GameNumber(List.of(0, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자는 1에서 9까지의 수로 이루어져야 합니다.");

    }

    @Test
    @DisplayName("중복된 숫자가 존재하면 예외가 발생한다.")
    void validateDuplicate() {
        assertThatThrownBy(() -> new GameNumber(List.of(2, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자는 서로 다른 수로 이루어져야 합니다.");

    }

    @Test
    @DisplayName("숫자의 개수가 3개가 아니라면 예외가 발생한다.")
    void validateSize() {
        assertThatThrownBy(() -> new GameNumber(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자의 개수는 3개로 이루어져야 합니다.");

    }

    @Test
    @DisplayName("방어적 복사를 사용할 시 내부의 값을 변경할 수 없다.")
    void defensiveCopy() {
        List<Integer> original = Arrays.asList(1,2,3);
        GameNumber gameNumber = new GameNumber(original);
        GameNumber target = new GameNumber(List.of(1,2,4));
        original.set(2, 4);
        assertThat(gameNumber.equals(target)).isFalse();
    }



}