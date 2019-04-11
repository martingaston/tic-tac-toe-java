class Game {
    private Messages messages = new Messages();
    private Player playerCross = new Player("X");
    private Player playerNought = new Player("O");
    private Player currentPlayer = playerCross;
    private Board board = new Board();
    private Rules rules = new Rules(board);
    private Display display = new Display(board);
    private boolean gameOver = false;
    private String winner = "";

    void intro() {
        Display.outMessage(messages.get("gameTitle"));
        Display.outMessage(messages.get("gameIntro"));
        Display.outMessage(messages.get("gameInstructions"));
    }

    void gameEnd() {
        display.showBoard();
        if (!winner.isEmpty()) {
            Display.outMessage(messages.get("gameOverWin", currentPlayer));
        } else {
            Display.outMessage(messages.get("gameOverDraw"));
        }
    }

    void newTurn() {
        display.showBoard();
        Display.outMessage(messages.get("playerTurn", currentPlayer));
        int playerInput = currentPlayer.getNextMove();
        board.updateBoard(playerInput, currentPlayer);
    }

    void processTurn() {
        gameOver = rules.gameIsOver();
        boolean hasWon = rules.hasWinningMove(currentPlayer);
        if (hasWon) {
            winner = currentPlayer.getSymbol();
            gameOver = true;
            return;
        }
        switchPlayer();
    }

    private void switchPlayer() {
        if (currentPlayer == playerCross) {
            currentPlayer = playerNought;
        } else {
            currentPlayer = playerCross;
        }
    }

    boolean isGameOver() {
        return gameOver;
    }
}
