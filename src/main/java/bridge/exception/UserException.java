package bridge.exception;

public enum UserException {

    INVALID_STRING("이동할 칸은 U 또는 D여야 합니다.");

    private final String exceptionMessage;

    UserException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }
}
