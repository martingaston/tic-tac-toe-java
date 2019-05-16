public class Cell {
    private Player occupant;

    Symbol getOccupant() {
        if (!isOccupied()) {
            return new Symbol(" ");
        }

        return occupant.symbol();
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
