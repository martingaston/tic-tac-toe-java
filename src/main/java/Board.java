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
        List<Integer> diagonalLeft = new LinkedList<>();
        List<Integer> diagonalRight = new LinkedList<>();

        for (int row = 0; row < this.sideLength; row++) {
            diagonalLeft.add(leftDiagonalAt(row));
            diagonalRight.add(rightDiagonalAt(row));
        }

        return Arrays.asList(
                new Line<>(diagonalLeft),
                new Line<>(diagonalRight)
         );
    }

    private Integer rightDiagonalAt(int row) {
        return this.sideLength - 1 + (row * this.sideLength) - row;
    }

    private Integer leftDiagonalAt(int row) {
        return row + (row * this.sideLength);
    }

    private List<Line> columns() {
        List<Line> verticalMoves = new LinkedList<>();

        for (int column = 0; column < this.sideLength; column++) {
            verticalMoves.add(columnAt(column));
        }

        return verticalMoves;
    }

    private Line<Integer> columnAt(int column) {
        List<Integer> populatedColumn = new LinkedList<>();
        for (int i = 0; i < sideLength;i++) {
            populatedColumn.add(column + sideLength * i);
        }

        return new Line<>(populatedColumn);
    }

    private List<Line> rows() {
        List<Line> horizontalMoves = new LinkedList<>();

        for (int row = 0; row < this.sideLength; row++) {
            horizontalMoves.add(rowAt(row));
        }

        return horizontalMoves;
    }

    private Line<Integer> rowAt(int row) {
        int startIndex = row * sideLength;

        List<Integer> populatedRow = new LinkedList<>();
        for (int i = startIndex; i < startIndex + sideLength; i++) {
            populatedRow.add(i);
        }

        return new Line<>(populatedRow);
    }

    public boolean hasWinner() {
        for (Line line : lines()) {
            if (line.hasWinner()) {
                return true;
            }
        }
        return false;
    }

    public static class Line<T> {
        private List<T> cells;

        public Line(List<T> cells) {
            this.cells = cells;
        }

        public boolean hasWinner() {
            System.out.println(toString());
            return false;
        }

        @Override
        public String toString() {
            StringBuilder stringify = new StringBuilder("Cell: ");
            for (T cell : cells) {
                stringify.append(cell);
                stringify.append(" ");
            }
            return stringify.toString();
        }
    }
}
