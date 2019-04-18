import java.util.Scanner;

class Game {
    private Messages messages = new Messages();

    private Board board = new Board();
    private Rules rules = new Rules(board);
    private Display display = new Display(board);

    private Player playerCross;
    private Player playerNought;
    private Players players;

    private boolean gameOver = false;
    private String winner = "";

    private void setUp() {
        Display.outMessage(messages.setupInstructions());
        Scanner input = new Scanner(System.in);
        int modeNumber = input.nextInt();
        switch(modeNumber) {
            case 1:
                this.playerCross = new PlayerHuman("X");
                this.playerNought = new PlayerHuman("O");
                break;
            case 2:
                this.playerCross = new PlayerHuman("X");
                this.playerNought = new PlayerCPU("O", board);
                break;
        }
        this.players = new Players(playerCross, playerNought);
    }

    void play() {
        intro();
        setUp();
        do {
            newTurn();
            processTurn();
        } while (!isGameOver());
        gameEnd();
    }

    private void intro() {
        Display.outMessage(messages.getIntro());
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
