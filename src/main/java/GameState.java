import java.util.List;
import java.util.Scanner;

public class GameState {
    private GameModes mode;
    private BoardModes board;
    private List<String> contents;
    private Players players;

    public GameState(List<String> variables) {
        this(variables, new IO(new Scanner(System.in)));
    }

    public GameState(List<String> variables, IO io) {
        board = BoardModes.nameOf(Integer.parseInt(variables.get(0)));
        mode = GameModes.nameOf(Integer.parseInt(variables.get(1)));
        contents = variables.subList(5, variables.size());
        players = Players.create(mode, io);
    }

    public GameModes mode() {
        return mode;
    }

    public List<String> contents() {
        return contents;
    }

    public Players players() {
        return players;
    }

    public BoardModes board() {
        return board;
    }

    // playerX = 2
    // playerO = 3
    // lastPlayer = 4
    // need a test for what happens if person quits game on FIRST turn 
}
