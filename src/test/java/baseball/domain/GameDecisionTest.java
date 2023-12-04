package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
class GameDecisionTest {

    @Test
    @DisplayName("특정 숫자가 게임결정과 연관된 숫자인지 알 수 있다.")
    void match(){
        assertAll(
                () -> assertThat(GameDecision.match(1)).isEqualTo(GameDecision.RESTART),
                () -> assertThat(GameDecision.match(2)).isEqualTo(GameDecision.QUIT)
        );
    }

    @Test
    @DisplayName("특정 숫자가 게임결정과 연관된 숫자가 아닐 시 예외가 발생한다.")
    void failMatch(){
        assertThatThrownBy(() -> GameDecision.match(3)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("재시작/종료에 해당하는 숫자가 아닙니다.");
    }

}