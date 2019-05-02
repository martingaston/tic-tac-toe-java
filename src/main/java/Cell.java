public class Cell {
    private Player occupant;

    String getOccupant() {
        if (isNotOccupied()) {
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

    boolean isNotOccupied() {
        return occupant == null;
    }

    boolean isOccupied() { return occupant != null; }
}
