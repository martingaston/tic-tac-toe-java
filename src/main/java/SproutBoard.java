import java.util.ArrayList;
import java.util.Set;

public class SproutBoard {
    private int totalCells = 9;
    private ArrayList<Cell> board = new ArrayList<>(totalCells);

    public SproutBoard() {
        board.addAll(generateEmptyBoard());
    }

    private Set<Cell> generateEmptyBoard() {
        return Set.of(
                new Cell(), new Cell(), new Cell(),
                new Cell(), new Cell(), new Cell(),
                new Cell(), new Cell(), new Cell()
        );
    }

    public Cell getCellFromBoardPosition(int position) {
        return board.get(position);
    }

    public int getTotalCells() {
        return totalCells;
    }

    public void addMoveToBoard(int position, Player player) {
        Cell requestedCell = board.get(position);
        if (requestedCell.isNotOccupied()) {
            requestedCell.mark(player);
        }
    }
}
