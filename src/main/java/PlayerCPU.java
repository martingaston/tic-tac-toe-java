public class PlayerCPU implements Player {
    private String symbol;
    private Rules rules;
    private int move;

    PlayerCPU(String symbol, Rules rules) {
        this.symbol = symbol;
        this.rules = rules;
    }

    public int getMove() {
        return this.move;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public int getNextMove() {
        do {
            this.move = pickRandomCell();
        } while (rules.isNotValidMove(this));

        oneSecondSleep();
        return this.move;
    }

    private int pickRandomCell() {
        return (int)Math.floor(Math.random() * 9);
    }

    private void oneSecondSleep() {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
