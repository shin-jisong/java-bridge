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

    private void validateMoving(String moving) {
        if (!moving.equals("U") && !moving.equals("D")) {
            throw new IllegalArgumentException(UserException.INVALID_STRING.getExceptionMessage());
        }
    }


}
