public class Cell {
    private Symbol occupant;

    Symbol getOccupant() {
        if (!isOccupied()) {
            return new Symbol(" ");
        }

        return occupant;
    }

    Symbol occupant() {
        return this.occupant;
    }

    void mark(Symbol symbol) {
        this.occupant = symbol;
    }

    void unmark() {
        this.occupant = null;
    }

    boolean isOccupied() {
        return occupant != null;
    }
}
