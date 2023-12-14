package bridge.exception;

public enum BridgeMakerException {
    INVALID_RANGE("다리 길이는 3부터 20 사이의 숫자여야 합니다.");

    private final String exceptionMessage;

    BridgeMakerException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }
}
