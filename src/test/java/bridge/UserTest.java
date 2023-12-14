package bridge;

import bridge.model.Bridge;
import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {

    @DisplayName("이동할 칸 입력 오류를 테스트한다")
    @Test
    void checkIsValidMoving() {
        assertRandomNumberInRangeTest(() -> {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            Bridge bridge = new Bridge(bridgeMaker.makeBridge(3));
            User user = new User(bridge);
            assertThatThrownBy(() -> user.canMoving("A"))
                    .isInstanceOf(IllegalArgumentException.class);
        }, 1, 0, 1);

    }

    @DisplayName("이동 가능을 테스트한다")
    @Test
    void checkCanMovingTrue() {
        assertRandomNumberInRangeTest(() -> {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            Bridge bridge = new Bridge(bridgeMaker.makeBridge(3));
            User user = new User(bridge);
            assertThat(user.canMoving("D")).isTrue();
        }, 1, 0, 1);

    }

    @DisplayName("이동 불가능을 테스트한다")
    @Test
    void checkCanMovingFalse() {
        assertRandomNumberInRangeTest(() -> {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            Bridge bridge = new Bridge(bridgeMaker.makeBridge(3));
            User user = new User(bridge);
            assertThat(user.canMoving("U")).isFalse();
        }, 1, 0, 1);

    }

    @DisplayName("다리 끝임을 테스트한다")
    @Test
    void checkIsFinishTrue() {
        assertRandomNumberInRangeTest(() -> {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            Bridge bridge = new Bridge(bridgeMaker.makeBridge(3));
            User user = new User(bridge);
            user.canMoving("D");
            user.canMoving("U");
            user.canMoving("D");
            assertThat(user.isFinish()).isTrue();
        }, 1, 0, 1);
    }

    @DisplayName("다리 끝이 아님을 테스트한다")
    @Test
    void checkIsFinishFalse() {
        assertRandomNumberInRangeTest(() -> {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            Bridge bridge = new Bridge(bridgeMaker.makeBridge(3));
            User user = new User(bridge);
            user.canMoving("D");
            assertThat(user.isFinish()).isFalse();
        }, 1, 0, 1);
    }
}
