package bridge.controller;

import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

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
    }
}
