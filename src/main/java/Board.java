import java.util.ArrayList;
import java.util.List;

public class Board {
    private int totalCells;
    private List<Cell> board = new ArrayList<>();

    public Board() {
        int defaultRowLength = 3;
        generateEmptyBoard(defaultRowLength);
    }

    public Board(int rowLength) {
        generateEmptyBoard(rowLength);
    }

    private void generateEmptyBoard(int rowLength) {
        totalCells = calculateTotalCellsFromRowLength(rowLength);
        for (int i = 0; i < totalCells; i++) {
            board.add(new Cell());
        }
    }

    private int calculateTotalCellsFromRowLength(int rowLength) {
        int squared = 2;
        return (int) Math.pow(rowLength, squared);
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
