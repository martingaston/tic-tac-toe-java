public class PlayerMinimax implements Player {
    private final String symbol;
    private final Player opponent;


    PlayerMinimax(String symbol, Player opponent) {
        this.symbol = symbol;
        this.opponent = opponent;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public int getNextMove(Board board) {
        oneSecondSleep();
        return new Minimax(board, this, opponent).optimal();
    }

    private void oneSecondSleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
