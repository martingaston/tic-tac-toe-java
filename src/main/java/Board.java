import java.util.ArrayList;
import java.util.List;

public class Board {
    private int totalCells;
    private int sideLength;
    private List<Cell> board = new ArrayList<>();

    public Board() {
        int defaultSideLength = 3;
        generateEmptyBoard(defaultSideLength);
    }

    public Board(int sideLength) {
        generateEmptyBoard(sideLength);
    }

    private void generateEmptyBoard(int sideLength) {
        this.sideLength = sideLength;
        this.totalCells = calculateTotalCellsFromSideLength(sideLength);
        for (int i = 0; i < totalCells; i++) {
            board.add(new Cell());
        }
    }

    private int calculateTotalCellsFromSideLength(int sideLength) {
        int squared = 2;
        return (int) Math.pow(sideLength, squared);
    }

    public Cell getCellFromBoardPosition(int position) {
        return board.get(position);
    }

    public int getTotalCells() {
        return this.totalCells;
    }

    int getSideLength() { return this.sideLength; }

    public void addMoveToBoard(int position, Player player) {
        Cell requestedCell = board.get(position);
        if (requestedCell.isNotOccupied()) {
            requestedCell.mark(player);
        }
    }
}
