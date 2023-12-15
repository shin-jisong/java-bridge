package bridge.controller;

import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.Objects;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;


    public BridgeController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        while (true) {
            try {
                outputView.printGameStart();
                int size = inputView.readBridgeSize();
                bridgeGame = new BridgeGame(size);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
        play();
    }

    private void play() {
        while (true) {
            try {
                String moving = inputView.readMoving();
                playing(bridgeGame.move(moving));
                break;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private void playing(boolean canMove) {
        if (canMove) {
            finishOrPlay();
            return;
        }
        retry();
    }

    private void finishOrPlay() {
        if (bridgeGame.finish()) {
            outputView.printResult(bridgeGame.getUserMove(), true, bridgeGame.getTrial());
            return;
        }
        play();
    }

    private void retry() {
        while (true) {
            try {
                String retry = inputView.readGameCommand();
                finishOrRetry(retry);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private void finishOrRetry(String retry) {
        if (Objects.equals(retry, "R")) {
            bridgeGame.retry();
            play();
            return;
        }
        outputView.printResult(bridgeGame.getUserMove(), false, bridgeGame.getTrial());
    }


}
