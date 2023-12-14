package bridge;

import bridge.model.Bridge;
import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
