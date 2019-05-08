import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Game {
    private Board board;
    private Display display;
    private Players players;
    private IO io;

    public Game(Board board, Display display, Players players, IO io) {
        this.board = board;
        this.display = display;
        this.players = players;
        this.io = io;
    }

    public Game() {
        //TODO update constructors
    }

    void play() {
        intro();
        instructions();
        do {
            newTurn();
            processTurn();
        } while (!board.isGameOver());
    }

    private void intro() {
        Display.outMessage(Messages.getIntro());
    }

    public void setUp(String[] args) {
        Map<String, String> parsedArgs = parseArgs(args);
        io = new IO(new Scanner(System.in));
        setUpBoard();
        setUpPlayers();
    }

    public Map<String,String> parseArgs(String[] args) {
        Pattern argStructure = Pattern.compile("^--(\\w+)=(\\w+)$");
        Map<String, String> argMap = new HashMap<>();

        for ( String arg : args) {
            Matcher matchedArg = argStructure.matcher(arg);
            if (matchedArg.matches()) {
                argMap.put(matchedArg.group(1), matchedArg.group(2));
            }
        }

        return argMap;
    }

    private void instructions() {
        Display.outMessage(Messages.getInstructions(board.sideLength()));
    }

    private void setUpPlayers() {
        Display.outMessage(Messages.setupInstructions());
        players = new Players(board, io);
    }

    private void setUpBoard() {
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
        display = new Display(board);
    }

    private void newTurn() {
        display.showBoard();
        Display.outMessage(Messages.announcePlayerTurn(currentPlayer()));
        int playerInput = currentPlayer().getNextMove();
        board.add(playerInput, currentPlayer());
    }

    private void processTurn() {
        if (board.isGameOver()) {
            gameEnd();
        } else {
            players.nextTurn();
        }
    }

    private Player currentPlayer() {
        return players.getCurrentPlayer();
    }

    private void gameEnd() {
        display.showBoard();

        if (board.hasWinner()) {
            Display.outMessage(Messages.playerWin(currentPlayer()));
        } else {
            Display.outMessage(Messages.playersDraw());
        }
    }
}
