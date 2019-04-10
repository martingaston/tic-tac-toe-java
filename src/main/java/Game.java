public class Game {
    private Messages messages = new Messages();
    private Player playerCross = new Player("X");
    private Player playerNought = new Player("O");
    private Player currentPlayer = playerCross;
    private Rules rules = new Rules();
    private BoardState boardState = new BoardState();
    private BoardDisplay boardDisplay = new BoardDisplay();
    private boolean gameOver = false;
    private String winner;

    public void intro() {
        messages.get("gameTitle");
        messages.get("gameIntro");
        messages.get("gameInstructions");
    }

    public void gameEnd() {
        if (!winner.isEmpty()) {
            messages.get("gameOverWin", currentPlayer);
        } else {
            messages.get("gameOverDraw");
        }
    }

    public void newTurn() {
        String[] currentState = boardState.getCurrentBoard();
        String renderedBoard = boardDisplay.render(currentState);
        boardDisplay.display(renderedBoard);
        messages.get("playerTurn", currentPlayer);
        currentPlayer.getNextMove();
    }

    public void processTurn() {
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
}
