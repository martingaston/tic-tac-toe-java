import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Settings {
    private static final int BOARD_3X3 = 1;
    private static final int BOARD_4X4 = 2;
    private static final int MODE_HVH = 1;
    private static final int MODE_HVC_EASY = 2;
    private static final int MODE_HVC_HARD = 3;
    private static final int MODE_CVC_EASY = 4;

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
        } else {
            processArgs(args);
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
        int boardNumber = Integer.parseInt(prevState.get(0));
        int modeNumber = Integer.parseInt(prevState.get(1));

        GameState gameState = new GameState(prevState);
        board = PopulatedBoard.from(gameState);
        players = gameState.players();
        playerCross = gameState.players().playerCross();
        playerNought = gameState.players().playerNought();
        display = new Display(board);

        if (gameState.players().getCurrentPlayer().getSymbol().equals("X")) {
            players.nextTurn();
        }

        createSettings(boardNumber, modeNumber); //TODO: this shouldn't be needed when final
    }

    private void createSettings(int boardNumber, int modeNumber) {
        gameSettings.add(Integer.toString(boardNumber));
        gameSettings.add(Integer.toString(modeNumber));
        gameSettings.add(playerCross.getSymbol());
        gameSettings.add(playerNought.getSymbol());
    }

    private void processArgs(String[] args) {
        Map<String, String> parsedArgs = parseArgs(args);
        String boardArg = parsedArgs.getOrDefault("board", "");
        String modeArg = parsedArgs.getOrDefault("mode", "");
        int boardNumber = getBoardNumber(boardArg);
        int modeNumber = getModeNumber(modeArg);

        buildBoard(boardNumber);
        buildMode(modeNumber);

        createSettings(boardNumber, modeNumber);

        display = new Display(board);
        players = new Players(playerCross, playerNought);
    }

    private void buildMode(int modeNumber) {
        switch (modeNumber) {
            case MODE_HVH:
            default:
                playerCross = new PlayerHuman("X", io);
                playerNought = new PlayerHuman("O", io);
                break;
            case MODE_HVC_EASY:
                playerCross = new PlayerHuman("X", io);
                playerNought = new PlayerCPU("O");
                break;
            case MODE_HVC_HARD:
                playerCross = new PlayerHuman("X", io);
                playerNought = new PlayerMinimax("O", playerCross);
                break;
            case MODE_CVC_EASY:
                playerCross = new PlayerCPU("X");
                playerNought = new PlayerCPU("O");
                break;
        }
    }

    private void buildBoard(int boardNumber) {
        switch (boardNumber) {
            case BOARD_3X3:
            default:
                board = new Board();
                break;
            case BOARD_4X4:
                board = new Board(4);
                break;
        }
    }

    private int getModeNumber(String modeArg) {
        int modeNumber;
        switch (modeArg) {
            case "hvh":
                modeNumber = MODE_HVH;
                break;
            case "hvc-easy":
                modeNumber = MODE_HVC_EASY;
                break;
            case "hvc-hard":
                modeNumber = MODE_HVC_HARD;
                break;
            case "cvc-easy":
                modeNumber = MODE_CVC_EASY;
                break;
            default:
                Display.outMessage(Messages.setupInstructions());
                modeNumber = io.nextInt();
        }
        return modeNumber;
    }

    private int getBoardNumber(String boardArg) {
        int boardNumber;

        switch (boardArg) {
            case "3x3":
                boardNumber = BOARD_3X3;
                break;
            case "4x4":
                boardNumber = BOARD_4X4;
                break;
            default:
                Display.outMessage(Messages.boardSetupInstructions());
                boardNumber = io.nextInt();
                break;
        }

        return boardNumber;
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
