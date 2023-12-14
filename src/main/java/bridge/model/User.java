package bridge.model;

import bridge.exception.UserException;
import java.util.ArrayList;
import java.util.List;

public class User {

    private List<String> userMove;
    private Bridge bridge;

    public User(Bridge bridge) {
        this.userMove = new ArrayList<>();
        this.bridge = bridge;
    }

    public List<String> getUserMove() {
        return userMove;
    }

    public boolean canMoving(String moving) {
        validateMoving(moving);
        if (bridge.isMovable(userMove.size(), moving)) {
            userMove.add(moving);
            return true;
        }
        return false;
    }

    public boolean isFinish() {
        return bridge.isEnd(userMove.size());
    }

    private void validateMoving(String moving) {
        if (!moving.equals("U") && !moving.equals("D")) {
            throw new IllegalArgumentException(UserException.INVALID_STRING.getExceptionMessage());
        }
    }


}
