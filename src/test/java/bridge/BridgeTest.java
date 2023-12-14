package bridge;

import bridge.model.Bridge;
import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {

    @DisplayName("다리 이동 가능을 테스트한다")
    @Test
    void checkIsMovableTrue() {
        assertRandomNumberInRangeTest(() -> {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            Bridge bridge = new Bridge(bridgeMaker.makeBridge(3));
            assertThat(bridge.isMovable(0, "D")).isTrue();
        }, 1, 0, 1);

    }
    @DisplayName("다리 이동 불가능을 테스트한다")
    @Test
    void checkIsMovableFalse() {
        assertRandomNumberInRangeTest(() -> {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            Bridge bridge = new Bridge(bridgeMaker.makeBridge(3));
            assertThat(bridge.isMovable(0, "U")).isFalse();
        }, 1, 0, 1);

    }

    @DisplayName("다리 끝임을 테스트한다")
    @Test
    void checkIsExitTrue() {
        assertRandomNumberInRangeTest(() -> {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            Bridge bridge = new Bridge(bridgeMaker.makeBridge(3));
            assertThat(bridge.isEnd(3)).isTrue();
        }, 1, 0, 1);

    }

    @DisplayName("다리 끝이 아님을 테스트한다")
    @Test
    void checkIsExitFalse() {
        assertRandomNumberInRangeTest(() -> {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            Bridge bridge = new Bridge(bridgeMaker.makeBridge(3));
            assertThat(bridge.isEnd(2)).isFalse();
        }, 1, 0, 1);

    }

}
