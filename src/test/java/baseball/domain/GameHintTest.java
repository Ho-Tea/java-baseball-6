package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GameHintTest {

    @ParameterizedTest
    @MethodSource("countData")
    @DisplayName("스트라이크와 볼의 개수로 게임 결과를 판단할 수 있다.")
    void of(int strikeCount, int ballCount, Map<GameHint, Integer> result) {
        assertThat(GameHint.of(strikeCount, ballCount)).isEqualTo(result);
    }


    static Stream<Arguments> countData() {
        return Stream.of(
                Arguments.of(3, 0, new EnumMap<>(Map.of(GameHint.BALL, 0, GameHint.STRIKE, 3))),
                Arguments.of(2, 1, new EnumMap<>(Map.of(GameHint.BALL, 1, GameHint.STRIKE, 2))),
                Arguments.of(1, 1, new EnumMap<>(Map.of(GameHint.BALL, 1, GameHint.STRIKE, 1))),
                Arguments.of(0, 2, new EnumMap<>(Map.of(GameHint.BALL, 2, GameHint.STRIKE, 0))),
                Arguments.of(0, 0, new EnumMap<>(Map.of(GameHint.NOTHING, 0)))
        );
    }
}