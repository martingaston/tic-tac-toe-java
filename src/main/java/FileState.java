import java.util.List;
import java.util.Scanner;

public class FileState implements GameState {
    private GameModes mode;
    private BoardModes boardMode;
    private Board board;
    private List<String> contents;
    private Players players;
    private String lastMove;

    public FileState(List<String> variables) {
        this(variables, new IO(new Scanner(System.in)));
    }

    public FileState(List<String> variables, IO io) {
        boardMode = BoardModes.nameOf(Integer.parseInt(variables.get(0)));
        mode = GameModes.nameOf(Integer.parseInt(variables.get(1)));
        contents = variables.subList(5, variables.size());
        players = Players.create(mode, io);
        lastMove = variables.get(4);

        if (lastMove().equals("X")) {
            players.nextTurn();
        }

        board = PopulatedBoard.from(this);
    }

    public GameModes mode() {
        return mode;
    }

    public BoardModes boardMode() { return boardMode; }

    public List<String> contents() {
        return contents;
    }

    public Players players() {
        return players;
    }

    public Board board() {
        return board;
    }

    public String lastMove() { return lastMove; }

    // playerX = 2
    // playerO = 3
    // need a test for what happens if person quits game on FIRST turn 
}
