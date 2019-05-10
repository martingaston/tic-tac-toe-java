import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

class Game {
    private static Board board;
    private static Display display;
    private static Players players;
    private static List<String> gameSettings;

    static void play(Settings settings) throws IOException {
        board = settings.board();
        display = settings.display();
        players = settings.players();
        gameSettings = settings.settingsList();

        intro();
        instructions();
        do {
            newTurn();
            processTurn();
        } while (!board.isGameOver());
    }

    private static void intro() {
        Display.outMessage(Messages.getIntro());
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

    private static void processTurn() throws IOException {
        List<String> boardState = new LinkedList<>(gameSettings);
        boardState.add(currentPlayer().getSymbol());
        boardState.addAll(board.toList());
        String boardCSV = String.join(",", boardState);
        IO.gameOut(boardCSV);
        if (board.isGameOver()) {
            IO.closeGame();
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
