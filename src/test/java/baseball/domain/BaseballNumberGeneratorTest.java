package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BaseballNumberGeneratorTest {

    public static final int ENOUGH_BIG_NUMBER = 10000;

    @Test
    @DisplayName("1에서 9까지 서로 다른 임의의 수 3개를 생성한다.")
    void generate() {
        for (int i = 0; i < ENOUGH_BIG_NUMBER; i++) {
            List<Integer> randomNums = BaseballNumberGenerator.generate();
            assertAll(
                    () -> assertThat(randomNums.stream().allMatch(num -> num >= 1 && num <= 9)).isTrue(),
                    () -> assertThat(randomNums.stream().distinct().toList().size()).isEqualTo(3),
                    () -> assertThat(randomNums.size()).isEqualTo(3)
            );
        }
    }
}