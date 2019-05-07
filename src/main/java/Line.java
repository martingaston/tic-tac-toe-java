import java.util.List;

public class Line {
    private final List<Cell> cells;

    public Line(List<Cell> cells) {
        this.cells = cells;
    }

    public boolean hasWinner() {
        Player occupant = cells.get(0).occupant();
        return hasWinner(occupant);
    }

    public boolean hasWinner(Player occupant) {
        for (Cell cell : cells) {
            if (cell.occupant() == null || cell.occupant() != occupant) {
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