public class Cell {
    private Player occupant;

    String getOccupant() {
        if (!isOccupied()) {
            return " ";
        }

        return occupant.getSymbol();
    }

    Player occupant() {
        return this.occupant;
    }

    void mark(Player player) {
        this.occupant = player;
    }

    void unmark() {
        this.occupant = null;
    }

    boolean isOccupied() {
        return occupant != null;
    }
}
