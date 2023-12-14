package bridge.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {

    private final static String GAME_START = "다리 건너기 게임을 시작합니다.\n";
    private final static String GAME_RESULT = "최종 게임 결과";
    private final static String GAME_SUCCESS = "게임 성공 여부: ";
    private final static String GAME_TRIAL = "총 시도한 횟수: ";
    private final static String PRINT_ERROR = "[ERROR] ";

    public void printGameStart() {
        System.out.println(GAME_START);
    }

    public void printResult(List<String> bridge, boolean move, int trial) {
        System.out.println(GAME_RESULT);
        printMap(bridge, move);
        printSuccess(move);
        printTrial(trial);
    }

    public void printError(String errMsg) {
        System.out.println(PRINT_ERROR + errMsg);
    }

    private void printTrial(int trial) {
        System.out.println(GAME_TRIAL + trial);
    }

    private void printSuccess(boolean move) {
        if (move) {
            System.out.println(GAME_SUCCESS + "성공\n");
            return;
        }
        System.out.println(GAME_SUCCESS + "실패\n");
    }

    public void printMap(List<String> bridge, boolean move) {
        char[][] map = makeMap(bridge);
        if (!move) {
            mapAddX(bridge.size() - 1, map);
        }
        String mapBridge = IntStream.range(0, map[0].length)
                .mapToObj(i -> "[" + map[0][i] + "]\n[" + map[1][i] + "]\n")
                .collect(Collectors.joining(" | "));
        System.out.println(mapBridge);
    }

    private void mapAddX(int lastIdx, char[][] map) {
        if (map[0][lastIdx] == 'O') {
            map[0][lastIdx] = 'X';
            return;
        }
        map[1][lastIdx] = 'X';
    }

    private char[][] makeMap(List<String> bridge) {
        char[][] map = new char[2][bridge.size()];
        for (int i = 0; i < bridge.size(); i++) {
            if (bridge.get(i).charAt(0) == 'U') {
                map[0][i] = 'O';
                continue;
            }
            map[1][i] = 'O';
        }
        return map;
    }
}
