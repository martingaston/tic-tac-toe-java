import java.util.*;

public class Settings {
    private final List<String> gameSettings = new LinkedList<>();
    private Board board;
    private Display display;
    private Players players;
    private Player playerCross;
    private Player playerNought;

    Settings(String[] args) {
        IO io = new IO(new Scanner(System.in));
        List<String> prevState = IO.gameIn();

        GameState state;
        if (!prevState.isEmpty()) {
            state = new FileState(prevState, io);
        } else if (args.length > 0) {
            state = new ArgState(args, io);
        } else {
            state = new InputState(io);
        }

        processState(state);
    }

    private void processState(GameState state) {
        board = state.board();
        players = state.players();
        playerCross = state.players().playerCross();
        playerNought = state.players().playerNought();
        display = new Display(board);

        //TODO: these three lines should not be needed when FileState is fully integrated
        createSettings(BoardModes.id(state.boardMode()), GameModes.id(state.mode()));
    }

    private void createSettings(int boardNumber, int modeNumber) {
        gameSettings.add(Integer.toString(boardNumber));
        gameSettings.add(Integer.toString(modeNumber));
        gameSettings.add(playerCross.getSymbol());
        gameSettings.add(playerNought.getSymbol());
    }

    public Board board() {
        return this.board;
    }

    public Display display() {
        return this.display;
    }

    public Players players() {
        return this.players;
    }

    public List<String> settingsList() {
        return this.gameSettings;
    }
}
