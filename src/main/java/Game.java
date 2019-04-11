class Game {
    private Messages messages;
    private Player playerCross = new Player("X");
    private Player playerNought = new Player("O");
    private Player currentPlayer = playerCross;
    private Rules rules = new Rules();
    private BoardState boardState = new BoardState();
    private BoardDisplay boardDisplay = new BoardDisplay();
    private boolean gameOver = false;
    private String winner = "";

    Game() {
        messages = new Messages();
    }

    void intro() {
        messages.display("gameTitle");
        messages.display("gameIntro");
        messages.display("gameInstructions");
    }

    void gameEnd() {
        if (!winner.isEmpty()) {
            messages.display("gameOverWin", currentPlayer);
        } else {
            messages.display("gameOverDraw");
        }
    }

    void newTurn() {
        String[] currentState = boardState.getCurrentBoard();
        String renderedBoard = boardDisplay.render(currentState);
        boardDisplay.display(renderedBoard);
        messages.display("playerTurn", currentPlayer);
        int playerInput = currentPlayer.getNextMove();
        boardState.updateBoard(playerInput, currentPlayer);
    }

    void processTurn() {
        String[] currentState = boardState.getCurrentBoard();
        gameOver = rules.gameIsOver(currentState);
        boolean hasWon = rules.hasWinningMove(currentState, currentPlayer);
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
