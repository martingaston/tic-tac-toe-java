import java.util.ArrayList;
import java.util.List;

public class Board {
    private int sideLength;
    private int totalCells;
    private List<Cell> board = new ArrayList<>();

    public Board() {
        this(3);
    }

    public Board(int sideLength) {
        generate(sideLength);
    }

    private void generate(int sideLength) {
        this.sideLength = sideLength;
        this.totalCells = sideLength * sideLength;
        for (int i = 0; i < this.totalCells; i++) {
            board.add(new Cell());
        }
    }

    public Cell getCell(int position) {
        return board.get(position);
    }

    public int getTotalCells() {
        return this.totalCells;
    }

    public List<Integer> available() {
        List<Integer> available = new ArrayList<>();
        for (int i = 0; i < this.totalCells; i++) {
            if(getCell(i).isNotOccupied()) {
                available.add(i);
            }
        }
        return available;
    }

    int getSideLength() { return this.sideLength; }

    public void addMove(int position, Player player) {
        Cell requestedCell = board.get(position);
        if (requestedCell.isNotOccupied()) {
            requestedCell.mark(player);
        }
    }
}
