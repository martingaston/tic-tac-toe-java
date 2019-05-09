import java.util.List;

public class PlayerCPU implements Player {
    private final String symbol;
    private final Board board;

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
        oneSecondSleep();
        return pickRandomCell();
    }

    private int pickRandomCell() {
        List<Integer> available = board.available();
        int cellIndex = (int) Math.floor(Math.random() * available.size());
        return available.get(cellIndex);
    }

    private void oneSecondSleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
