import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Board {
    private int totalCells;
    private List<Cell> board = new ArrayList<>();

    public Board() {
        this.board.addAll(generateEmptyBoard());
        totalCells = this.board.size();
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
