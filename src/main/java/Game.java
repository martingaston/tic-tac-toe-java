import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Game {
    private static Board board;
    private static Display display;
    private static Players players;
    private static IO io;

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
        Player playerCross;
        Player playerNought;
        int boardNumber;

        final int BOARD_3X3 = 1;
        final int BOARD_4X4 = 2;

        final int MODE_HVH = 1;
        final int MODE_HVC_EASY = 2;
        final int MODE_HVC_HARD = 3;
        final int MODE_CVC_EASY = 4;

        if(parsedArgs.containsKey("board")) {
           switch(parsedArgs.get("board")) {
               case "3x3":
               default:
                   boardNumber = BOARD_3X3;
                   break;
               case "4x4":
                   boardNumber = BOARD_4X4;
                   break;
           }
        } else {
            Display.outMessage(Messages.boardSetupInstructions());
            boardNumber = io.nextInt();
        }

        switch (boardNumber) {
            case BOARD_3X3:
            default:
                board = new Board();
                break;
            case BOARD_4X4:
                board = new Board(4);
                break;
        }

        int modeNumber;

        if(parsedArgs.containsKey("mode")) {
            switch(parsedArgs.get("mode")) {
                case "hvh":
                default:
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
            }
        } else {
            Display.outMessage(Messages.setupInstructions());
            modeNumber = io.nextInt();
        }

        switch (modeNumber) {
            case MODE_HVH:
            default:
                playerCross = new PlayerHuman("X", board, io);
                playerNought = new PlayerHuman("O", board, io);
                break;
            case MODE_HVC_EASY:
                playerCross = new PlayerHuman("X", board, io);
                playerNought = new PlayerCPU("O", board);
                break;
            case MODE_HVC_HARD:
                playerCross = new PlayerHuman("X", board, io);
                playerNought = new PlayerMinimax("O", board, playerCross);
                break;
            case MODE_CVC_EASY:
                playerCross = new PlayerCPU("X", board);
                playerNought = new PlayerCPU("O", board);
                break;
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
