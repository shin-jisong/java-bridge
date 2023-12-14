package bridge.exception;

public enum BridgeMakerException {
    INVALID_RANGE("유효하지 않은 다리 길이입니다. 다시 입력해 주세요.");

    private final String exceptionMessage;

    BridgeMakerException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }
}
