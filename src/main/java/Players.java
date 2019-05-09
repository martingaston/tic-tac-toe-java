class Players {
    private final Player playerCross;
    private final Player playerNought;
    private Player currentPlayer;

    public Players(Player playerCross, Player playerNought) {
        this.playerCross = playerCross;
        this.playerNought = playerNought;
        this.currentPlayer = this.playerCross;
    }

    public void nextTurn() {
        if (currentPlayer == playerCross) {
            currentPlayer = playerNought;
        } else {
            currentPlayer = playerCross;
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
