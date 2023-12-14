package bridge;

import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeMakerTest {

    @DisplayName("다리 생성을 테스트한다")
    @Test
    void checkMakeBridge() {
        assertRandomNumberInRangeTest(() -> {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            assertThat(bridgeMaker.makeBridge(3)).isEqualTo(List.of("D", "U", "D"));
        }, 1, 0, 1);

    }


}
