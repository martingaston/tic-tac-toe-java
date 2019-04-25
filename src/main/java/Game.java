import java.util.Scanner;

class Game {
    private Messages messages = new Messages();

    private Board board;
    private Rules rules;
    private Display display;
    private Players players;
    private boolean gameOver = false;
    private String winner = "";

    void play() {
        intro();
        setUp();
        instructions();
        do {
            newTurn();
            processTurn();
        } while (!isGameOver());
        gameEnd();
    }

    private void intro() {
        Display.outMessage(messages.getIntro());
    }

    private void setUp() {
        setUpBoard();
        setUpPlayers();
    }

    private void instructions() {
        Display.outMessage(messages.getInstructions(board.getSideLength()));
    }

    private void setUpPlayers() {
        Display.outMessage(messages.setupInstructions());
        players = new Players(rules, board);
    }

    private void setUpBoard() {
        Display.outMessage(messages.boardSetupInstructions());
        Scanner input = new Scanner(System.in);
        int modeNumber = input.nextInt();
        switch(modeNumber) {
            case 1:
                board = new Board();
                break;
            case 2:
                board = new Board(4);
                break;
        }
        rules = new Rules(board);
        display = new Display(board);
    }

    private void newTurn() {
        display.showBoard();
        Display.outMessage(messages.announcePlayerTurn(currentPlayer()));
        int playerInput = currentPlayer().getNextMove();
        board.addMoveToBoard(playerInput, currentPlayer());
    }

    private void processTurn() {
        gameOver = rules.gameIsOver();
        boolean hasWon = rules.hasWinningMove(currentPlayer());
        if (hasWon) {
            winner = currentPlayer().getSymbol();
            gameOver = true;
            return;
        }
        switchPlayer();
    }

    private void switchPlayer() {
        players.nextTurn();
    }

    private Player currentPlayer() {
        return players.getCurrentPlayer();
    }

    private void gameEnd() {
        display.showBoard();
      
        if (aPlayerHasWon()) {
            Display.outMessage(messages.playerWin(currentPlayer()));
        } else {
            Display.outMessage(messages.playersDraw());
        }
    }

    private boolean aPlayerHasWon() { return this.gameOver && !this.winner.isEmpty(); }

    private boolean isGameOver() {
        return gameOver;
    }
}
