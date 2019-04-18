public class PlayerCPU implements Player {
    private String symbol;
    private Board board;

    PlayerCPU(String symbol, Board board) {
        this.symbol = symbol;
        this.board = board;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public int getNextMove() {
        int randomGuess;
        do {
            randomGuess = pickRandomCell();
        } while (isCPUMoveValid(randomGuess));
        oneSecondSleep();
        return randomGuess;
    }

    private int pickRandomCell() {
        return (int)Math.floor(Math.random() * board.getTotalCells());
    }

    private void oneSecondSleep() {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    private boolean isCPUMoveValid(int cellNumber) {
        Cell queriedCell = board.getCellFromBoardPosition(cellNumber);
        return !queriedCell.isNotOccupied();
    }
}
