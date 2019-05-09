import java.util.List;

class Line {
    private final List<Cell> cells;

    public Line(List<Cell> cells) {
        this.cells = cells;
    }

    public boolean hasWinner() {
        Player occupant = cells.get(0).occupant();
        return hasWinner(occupant);
    }

    public boolean hasWinner(Player occupant) {
        return cells.stream().allMatch(cell -> cell.occupant() == occupant && cell.occupant() != null);
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