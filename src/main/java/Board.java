import java.util.ArrayList;
import java.util.List;

public class Board {
    private int sideLength;
    private List<Cell> board = new ArrayList<>();

    public Board() {
        this.sideLength = 3;
        generateEmptyBoard();
    }

    public Board(int sideLength) {
        this.sideLength = sideLength;
        generateEmptyBoard();
    }

    private void generateEmptyBoard() {
        int totalCells = this.sideLength * this.sideLength;
        for (int i = 0; i < totalCells; i++) {
            board.add(new Cell());
        }
    }

    public Cell getCellFromBoardPosition(int position) {
        return board.get(position);
    }

    public int getTotalCells() {
        return this.sideLength * this.sideLength;
    }

    public List<Integer> getAvailableIndexes() {
        int totalCells = getTotalCells();
        List<Integer> availableCells = new ArrayList<>();

        for (int position = 0; position < totalCells; position++) {
            if (board.get(position).isNotOccupied()) {
                availableCells.add(position);
            }
        }

        return availableCells;
    }

    int getSideLength() { return this.sideLength; }

    public void addMoveToBoard(int position, Player player) {
        Cell requestedCell = board.get(position);
        if (requestedCell.isNotOccupied()) {
            requestedCell.mark(player);
        }
    }

    public void removeMoveFromBoard(int position) {
        Cell requestedCell = board.get(position);
        if (requestedCell.isOccupied()) {
            requestedCell.unmark();
        }
    }
}
