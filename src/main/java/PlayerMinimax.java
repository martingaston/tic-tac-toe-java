public class PlayerMinimax implements Player {
    private final String symbol;
    private final Minimax minimax;


    PlayerMinimax(String symbol, Board board, Player opponent) {
        this.symbol = symbol;
        minimax = new Minimax(board, this, opponent);
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public int getNextMove() {
        oneSecondSleep();
        return minimax.optimal();
    }

    private void oneSecondSleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
