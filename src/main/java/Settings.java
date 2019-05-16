import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Settings {
    private final List<String> gameSettings = new LinkedList<>();
    private IO io;
    private Board board;
    private Display display;
    private Players players;
    private Player playerCross;
    private Player playerNought;

    Settings(String[] args) {
        io = new IO(new Scanner(System.in));
        List<String> prevState = IO.gameIn();

        if (!prevState.isEmpty()) {
            processSavedGame(prevState);
        } else if (args.length > 0) {
            processArgsFromState(args);
        } else {
            processInputFromState(io);
        }
    }

    public static Map<String, String> parseArgs(String[] args) {
        Pattern argStructure = Pattern.compile("^--(\\w+)=([\\w|-]+)$");
        Map<String, String> argMap = new HashMap<>();

        for (String arg : args) {
            Matcher matchedArg = argStructure.matcher(arg);
            if (matchedArg.matches()) {
                argMap.put(matchedArg.group(1), matchedArg.group(2));
            }
        }

        return argMap;
    }

    private void processSavedGame(List<String> prevState) {
        GameState fileState = new FileState(prevState);
        board = fileState.board();
        players = fileState.players();
        playerCross = fileState.players().playerCross();
        playerNought = fileState.players().playerNought();
        display = new Display(board);

        //TODO: these three lines should not be needed when FileState is fully integrated
        createSettings(BoardModes.id(fileState.boardMode()), GameModes.id(fileState.mode()));
    }

    private void createSettings(int boardNumber, int modeNumber) {
        gameSettings.add(Integer.toString(boardNumber));
        gameSettings.add(Integer.toString(modeNumber));
        gameSettings.add(playerCross.getSymbol());
        gameSettings.add(playerNought.getSymbol());
    }

    private void processArgsFromState(String[] args) {
        GameState argState = new ArgState(args);
        board = argState.board();
        players = argState.players();
        playerCross = argState.players().playerCross();
        playerNought = argState.players().playerNought();
        display = new Display(board);

        createSettings(BoardModes.id(argState.boardMode()), GameModes.id(argState.mode()));
    }

    private void processInputFromState(IO io) {
        GameState inputState = new InputState(io);
        board = inputState.board();
        players = inputState.players();
        playerCross = inputState.players().playerCross();
        playerNought = inputState.players().playerNought();
        display = new Display(board);

        createSettings(BoardModes.id(inputState.boardMode()), GameModes.id(inputState.mode()));
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
