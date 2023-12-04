package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    @ParameterizedTest
    @MethodSource("compareData")
    @DisplayName("자신의 숫자와 플레이어가 입력한 숫자에 대한 비교 결과를 알 수 있다.")
    void compare(BaseballNumber computerBaseballNum, BaseballNumber userBaseballNum, Map<GameHint, Integer> result){
        assertThat(new Computer(computerBaseballNum).compare(userBaseballNum)).isEqualTo(result);
    }

    static Stream<Arguments> compareData() {
        return Stream.of(
                Arguments.of(new BaseballNumber(List.of(1,2,3)), new BaseballNumber(List.of(1,2,3)), new EnumMap<>(Map.of(GameHint.BALL, 0, GameHint.STRIKE, 3))),
                Arguments.of(new BaseballNumber(List.of(1,2,3)), new BaseballNumber(List.of(4,2,3)), new EnumMap<>(Map.of(GameHint.BALL, 0, GameHint.STRIKE, 2))),
                Arguments.of(new BaseballNumber(List.of(1,2,3)), new BaseballNumber(List.of(1,3,5)), new EnumMap<>(Map.of(GameHint.BALL, 1, GameHint.STRIKE, 1))),
                Arguments.of(new BaseballNumber(List.of(1,2,3)), new BaseballNumber(List.of(3,1,4)), new EnumMap<>(Map.of(GameHint.BALL, 2, GameHint.STRIKE, 0))),
                Arguments.of(new BaseballNumber(List.of(1,2,3)), new BaseballNumber(List.of(4,5,6)), new EnumMap<>(Map.of(GameHint.NOTHING, 0)))
        );
    }
}