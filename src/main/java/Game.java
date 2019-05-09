import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Game {
    private static Board board;
    private static Display display;
    private static Players players;
    private static IO io;
    private static Player playerCross;
    private static Player playerNought;

    static void play(String[] args) {
        intro();
        setUp(args);
        instructions();
        do {
            newTurn();
            processTurn();
        } while (!board.isGameOver());
    }

    private static void intro() {
        Display.outMessage(Messages.getIntro());
    }

    public static void setUp(String[] args) {
        io = new IO(new Scanner(System.in));
        Map<String, String> parsedArgs = parseArgs(args);
        processArgs(parsedArgs);
    }

    private static void processArgs(Map<String, String> parsedArgs) {
        if(parsedArgs.containsKey("board")) {
            switch (parsedArgs.get("board")) {
                case "3x3":
                    board = new Board();
                    break;
                case "4x4":
                    board = new Board(4);
                    break;
                default:
                    setUpBoard();
                    break;
            }
        } else {
            setUpBoard();
        }

        if(parsedArgs.containsKey("mode")) {
            switch (parsedArgs.get("mode")) {
                case "hvh":
                    playerCross = new PlayerHuman("X", board, io);
                    playerNought = new PlayerHuman("O", board, io);
                    break;
                case "hvc-easy":
                    playerCross = new PlayerHuman("X", board, io);
                    playerNought = new PlayerCPU("O", board);
                    break;
                case "hvc-hard":
                    playerCross = new PlayerHuman("X", board, io);
                    playerNought = new PlayerMinimax("O", board, playerCross);
                    break;
                case "cvc-easy":
                    playerCross = new PlayerCPU("X", board);
                    playerNought = new PlayerCPU("O", board);
                    break;
                default:
                    setUpPlayers();
                    break;
            }
        } else {
            setUpPlayers();
        }

        display = new Display(board);
        players = new Players(playerCross, playerNought);
    }

    public static Map<String,String> parseArgs(String[] args) {
        Pattern argStructure = Pattern.compile("^--(\\w+)=([\\w|-]+)$");
        Map<String, String> argMap = new HashMap<>();

        for ( String arg : args) {
            Matcher matchedArg = argStructure.matcher(arg);
            if (matchedArg.matches()) {
                argMap.put(matchedArg.group(1), matchedArg.group(2));
            }
        }

        return argMap;
    }

    private static void instructions() {
        Display.outMessage(Messages.getInstructions(board.sideLength()));
    }

    private static void setUpPlayers() {
        Display.outMessage(Messages.setupInstructions());
        int modeNumber = io.nextInt();
        switch (modeNumber) {
            case 1:
            default:
                playerCross = new PlayerHuman("X", board, io);
                playerNought = new PlayerHuman("O", board, io);
                break;
            case 2:
                playerCross = new PlayerHuman("X", board, io);
                playerNought = new PlayerCPU("O", board);
                break;
            case 3:
                playerCross = new PlayerHuman("X", board, io);
                playerNought = new PlayerMinimax("O", board, playerCross);
                break;
            case 4:
                playerCross = new PlayerCPU("X", board);
                playerNought = new PlayerCPU("O", board);
                break;
        }
    }

    private static void setUpBoard() {
        Display.outMessage(Messages.boardSetupInstructions());
        int modeNumber = io.nextInt();
        switch (modeNumber) {
            case 1:
                board = new Board();
                break;
            case 2:
                board = new Board(4);
                break;
        }
    }

    private static void newTurn() {
        display.showBoard();
        Display.outMessage(Messages.announcePlayerTurn(currentPlayer()));
        int playerInput = currentPlayer().getNextMove();
        board.add(playerInput, currentPlayer());
    }

    private static void processTurn() {
        if (board.isGameOver()) {
            gameEnd();
        } else {
            players.nextTurn();
        }
    }

    private static Player currentPlayer() {
        return players.getCurrentPlayer();
    }

    private static void gameEnd() {
        display.showBoard();

        if (board.hasWinner()) {
            Display.outMessage(Messages.playerWin(currentPlayer()));
        } else {
            Display.outMessage(Messages.playersDraw());
        }
    }
}
