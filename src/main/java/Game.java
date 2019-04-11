class Game {
    private Messages messages = new Messages();
    private Player playerCross = new Player("X");
    private Player playerNought = new Player("O");
    private Player currentPlayer = playerCross;
    private Rules rules = new Rules();
    private BoardState boardState = new BoardState();
    private BoardDisplay boardDisplay = new BoardDisplay();
    private boolean gameOver = false;
    private String winner = "";

    void intro() {
        Display.outMessage(messages.get("gameTitle"));
        Display.outMessage(messages.get("gameIntro"));
        Display.outMessage(messages.get("gameInstructions"));
    }

    void gameEnd() {
        String[] currentState = boardState.getCurrentBoard();
        String renderedBoard = boardDisplay.render(currentState);
        Display.outBoard(renderedBoard);
        if (!winner.isEmpty()) {
            Display.outMessage(messages.get("gameOverWin", currentPlayer));
        } else {
            Display.outMessage(messages.get("gameOverDraw"));
        }
    }

    void newTurn() {
        String[] currentState = boardState.getCurrentBoard();
        String renderedBoard = boardDisplay.render(currentState);
        Display.outBoard(renderedBoard);
        Display.outMessage(messages.get("playerTurn", currentPlayer));
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
