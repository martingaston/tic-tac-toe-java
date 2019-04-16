public class Cell {
    private Player occupant;

    String getOccupant() {
        if (isOccupied()) {
            return occupant.getSymbol();
        }

        return " ";
    }

    void mark(Player player) {
        this.occupant = player;
    }

    private boolean isOccupied() {
        return occupant != null;
    }
}
