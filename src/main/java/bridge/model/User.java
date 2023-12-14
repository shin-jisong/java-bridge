package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<String> userMove;
    private Bridge bridge;

    public User(Bridge bridge) {
        this.userMove = new ArrayList<>();
        this.bridge = bridge;
    }
}
