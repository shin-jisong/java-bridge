package bridge.view;

import bridge.exception.InputException;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        return 0;
    }

    public String readMoving() {
        return null;
    }

    public String readGameCommand() {
        return null;
    }

    private void validateInteger(String str) {
        if (!str.matches("^-?\\d+$")) {
            throw new IllegalArgumentException(InputException.INVALID_SIZE.getExceptionMessage());
        }
    }
}
