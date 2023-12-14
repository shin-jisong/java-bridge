package bridge.view;

import bridge.exception.InputException;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final static String READ_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private final static String READ_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final static String READ_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public int readBridgeSize() {
        System.out.println(READ_BRIDGE_SIZE);
        String size = Console.readLine();
        validateInteger(size);
        return Integer.parseInt(size);
    }

    public String readMoving() {
        System.out.println(READ_MOVING);
        String moving = Console.readLine();
        validateMoving(moving);
        return moving;
    }

    public String readGameCommand() {
        System.out.println(READ_GAME_COMMAND);
        String gameCommand = Console.readLine();
        validateGameCommand(gameCommand);
        return gameCommand;
    }
    
    private void validateGameCommand(String str) {
        if (!str.equals("R") && !str.equals("Q")) {
            throw new IllegalArgumentException(InputException.INVALID_GAME_COMMAND.getExceptionMessage());
        }
    }

    private void validateMoving(String str) {
        if (str.length() != 1) {
            throw new IllegalArgumentException(InputException.INVALID_MOVING.getExceptionMessage());
        }
    }

    private void validateInteger(String str) {
        if (!str.matches("^-?\\d+$")) {
            throw new IllegalArgumentException(InputException.INVALID_SIZE.getExceptionMessage());
        }
    }
}
