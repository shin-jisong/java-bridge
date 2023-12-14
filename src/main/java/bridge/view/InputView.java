package bridge.view;

import bridge.exception.InputException;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final static String READ_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private final static String READ_MOVING  ="이동할 칸을 선택해주세요. (위: U, 아래: D)";

    public int readBridgeSize() {
        System.out.println(READ_BRIDGE_SIZE);
        String size = Console.readLine();
        validateInteger(size);
        return Integer.parseInt(size);
    }

    public String readMoving() {
        System.out.println(READ_MOVING);
        String moving = Console.readLine();
        return moving;
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
