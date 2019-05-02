import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Board {
    private int sideLength;
    private int totalCells;
    private List<Cell> board = new ArrayList<>();

    public Board() {
        this(3);
    }

    public Board(int sideLength) {
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

    int getSideLength() { return this.sideLength; }

    public void addMove(int position, Player player) {
        Cell requestedCell = board.get(position);
        if (requestedCell.isNotOccupied()) {
            requestedCell.mark(player);
        }
    }

    public List<Line> lines() {
        List<Line> lines = new LinkedList<>();
        lines.addAll(rows());
        lines.addAll(columns());
        lines.addAll(diagonals());
        return lines;
    }

    private List<Line> diagonals() {
        List<Cell> diagonalLeft = new LinkedList<>();
        List<Cell> diagonalRight = new LinkedList<>();

        for (int row = 0; row < this.sideLength; row++) {
            diagonalLeft.add(leftDiagonalAt(row));
            diagonalRight.add(rightDiagonalAt(row));
        }

        return Arrays.asList(
                new Line(diagonalLeft),
                new Line(diagonalRight)
         );
    }

    private Cell rightDiagonalAt(int row) {
        return getCell(this.sideLength - 1 + (row * this.sideLength) - row);
    }

    private Cell leftDiagonalAt(int row) {
        return getCell(row + (row * this.sideLength));
    }

    private List<Line> columns() {
        List<Line> verticalMoves = new LinkedList<>();

        for (int column = 0; column < this.sideLength; column++) {
            verticalMoves.add(columnAt(column));
        }

        return verticalMoves;
    }

    private Line columnAt(int column) {
        List<Cell> populatedColumn = new LinkedList<>();
        for (int i = 0; i < sideLength;i++) {
            populatedColumn.add(getCell(column + sideLength * i));
        }

        return new Line(populatedColumn);
    }

    private List<Line> rows() {
        List<Line> horizontalMoves = new LinkedList<>();

        for (int row = 0; row < this.sideLength; row++) {
            horizontalMoves.add(rowAt(row));
        }

        return horizontalMoves;
    }

    private Line rowAt(int row) {
        int startIndex = row * sideLength;

        List<Cell> populatedRow = new LinkedList<>();
        for (int i = startIndex; i < startIndex + sideLength; i++) {
            populatedRow.add(getCell(i));
        }

        return new Line(populatedRow);
    }

    public boolean hasWinner() {
        for (Line line : lines()) {
            if (line.hasWinner()) {
                return true;
            }
        }
        return false;
    }

    public boolean isGameOver() {
        for (int i = 0; i < this.totalCells; i++) {
            if(board.get(i).isNotOccupied()) {
                return false;
            }
        }

        return true;
    }

    public static class Line {
        private List<Cell> cells;

        public Line(List<Cell> cells) {
            this.cells = cells;
        }

        public boolean hasWinner() {
            Player occupant = cells.get(0).occupant();
            for (Cell cell : cells) {
                if (cell.occupant() != occupant) {
                    return false;
                }
            }

            return true;
        }

        @Override
        public String toString() {
            StringBuilder stringify = new StringBuilder("Cell: ");
            for (Cell cell : cells) {
                stringify.append("| isOccupied: ").append(cell.isOccupied());
                if (cell.isOccupied()) {
                    stringify.append(", occupant: ").append(cell.getOccupant());
                }
                stringify.append(" | ");
            }
            return stringify.toString();
        }
    }
}
