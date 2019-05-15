class Players {
    private final Player playerCross;
    private final Player playerNought;
    private Player currentPlayer;

    public static Players create(GameConstants mode, IO io) {
        Player playerCross;
        Player playerNought;
        switch (mode) {
            case MODE_HVH:
            default:
                playerCross = new PlayerHuman("X", io);
                playerNought = new PlayerHuman("O", io);
                break;
            case MODE_HVC_EASY:
                playerCross = new PlayerHuman("X", io);
                playerNought = new PlayerCPU("O");
                break;
            case MODE_HVC_HARD:
                playerCross = new PlayerHuman("X", io);
                playerNought = new PlayerMinimax("O", playerCross);
                break;
            case MODE_CVC_EASY:
                playerCross = new PlayerCPU("X");
                playerNought = new PlayerCPU("O");
                break;
        }

        return new Players(playerCross, playerNought);
    }

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
