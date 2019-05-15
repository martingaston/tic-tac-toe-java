import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameState {
    private GameConstants mode;
    private GameConstants board;

    public GameState(List<String> variables) {
        Map<Integer, GameConstants> modeMap = new HashMap<>(Map.of(
                1, GameConstants.MODE_HVH,
                2, GameConstants.MODE_HVC_EASY,
                3, GameConstants.MODE_HVC_HARD,
                4, GameConstants.MODE_CVC_EASY
        ));

        Map<Integer, GameConstants> boardMap = new HashMap<>(Map.of(
                1, GameConstants.BOARD_3X3,
                2, GameConstants.BOARD_4X4
        ));

        board = boardMap.getOrDefault(Integer.parseInt(variables.get(0)), GameConstants.BOARD_3X3);
        mode = modeMap.getOrDefault(Integer.parseInt(variables.get(1)), GameConstants.MODE_HVH);
    }

    public GameConstants mode() {
        return mode;
    }

    public GameConstants board() {
        return board;
    }

    // board = 0
    // mode = 1
    // playerX = 2
    // playerO = 3
    // lastPlayer = 4
    // board = 5+
    // need a test for what happens if person quits game on FIRST turn 
}
