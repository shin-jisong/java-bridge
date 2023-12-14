package bridge.model;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int trial;
    private Bridge bridge;
    private User user;

    public BridgeGame(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.trial = 1;
        this.bridge = new Bridge(bridgeMaker.makeBridge(size));
        this.user = new User(bridge);
    }
    public boolean move(String moving) {
        return user.canMoving(moving);
    }

    public boolean finish() {
        return user.isFinish();
    }

    public void retry() {
        this.trial += 1;
        this.user = new User(bridge);
    }

    public int getTrial() {
        return this.trial;
    }

    public List<String> getUserMove() {
        return user.getUserMove();
    }
}
