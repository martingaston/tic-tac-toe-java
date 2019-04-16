public class Cell {
    private Player occupant;

    String getOccupant() {
        if (isNotOccupied()) {
            return " ";
        }

        return occupant.getSymbol();
    }

    void mark(Player player) {
        this.occupant = player;
    }

    private boolean isNotOccupied() {
        return occupant == null;
    }
}
