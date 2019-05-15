import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GameState {
    private GameConstants mode;
    private GameConstants board;
    private List<String> contents;
    private Players players;

    public GameState(List<String> variables) {
        this(variables, new IO(new Scanner(System.in)));
    }

    public GameState(List<String> variables, IO io) {
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
        contents = variables.subList(5, variables.size());
        players = Players.create(mode, io);

    }

    public GameConstants mode() {
        return mode;
    }

    public List<String> contents() {
        return contents;
    }

    public Players players() {
        return players;
    }

    public GameConstants board() {
        return board;
    }

    // playerX = 2
    // playerO = 3
    // lastPlayer = 4
    // need a test for what happens if person quits game on FIRST turn 
}
