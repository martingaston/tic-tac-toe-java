import java.util.Scanner;

class Game {
    private Board board;
    private Display display;
    private Players players;

    void play() {
        intro();
        setUp();
        instructions();
        do {
            newTurn();
            processTurn();
        } while (!board.isGameOver());
    }

    private void intro() {
        Display.outMessage(Messages.getIntro());
    }

    private void setUp() {
        setUpBoard();
        setUpPlayers();
    }

    private void instructions() {
        Display.outMessage(Messages.getInstructions(board.sideLength()));
    }

    private void setUpPlayers() {
        Display.outMessage(Messages.setupInstructions());
        players = new Players(board);
    }

    private void setUpBoard() {
        Display.outMessage(Messages.boardSetupInstructions());
        Scanner input = new Scanner(System.in);
        int modeNumber = input.nextInt();
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
