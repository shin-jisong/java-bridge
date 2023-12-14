package bridge.model;

import java.util.List;
import java.util.Objects;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isMovable(int order, String moving) {
        return Objects.equals(bridge.get(order), moving);
    }

    public boolean isEnd(int size) {
        return bridge.size() == size;
    }
}
