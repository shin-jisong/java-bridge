package bridge.exception;

public enum InputException {

    INVALID_SIZE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_MOVING("이동할 칸은 U 또는 D여야 합니다.");

    private final String exceptionMessage;

    InputException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }
}
