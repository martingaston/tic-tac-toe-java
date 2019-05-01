public class PlayerCPU implements Player {
    private String symbol;
    private Rules rules;
    private int totalCells;

    PlayerCPU(String symbol, Rules rules, Board board) {
        this.symbol = symbol;
        this.rules = rules;
        this.totalCells = board.getTotalCells();
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public int getNextMove() {
        int desiredCell;
        do {
            desiredCell = pickRandomCell();
        } while (rules.isNotValidMove(desiredCell));

        oneSecondSleep();
        return desiredCell;
    }

    private int pickRandomCell() {
        return (int)Math.floor(Math.random() * totalCells);
    }

    private void oneSecondSleep() {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
