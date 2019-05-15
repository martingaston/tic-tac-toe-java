import java.util.List;

public class PlayerCPU implements Player {
    private final String symbol;

    PlayerCPU(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public int getNextMove(Board board) {
        oneSecondSleep();
        return pickRandomCell(board.available());
    }

    private int pickRandomCell(List<Integer> available) {
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
