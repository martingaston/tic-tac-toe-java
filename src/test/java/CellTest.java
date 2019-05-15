import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CellTest {
    private Player playerCross;
    private Player playerNought;
    private Cell cell;

    @Before
    public void setUp() {
        Board board = new Board();
        playerCross = new PlayerHuman("X");
        playerNought = new PlayerHuman("O");
        cell = new Cell();
    }

    @Test
    public void unoccupiedCellIsABlankSpace() {
        String unoccupiedCell = cell.getOccupant();
        assertEquals(" ", unoccupiedCell);
    }

    @Test
    public void cellOccupiedByCrossReturnsCross() {
        cell.mark(playerCross);
        String crossOccupiedCell = cell.getOccupant();
        assertEquals("X", crossOccupiedCell);
    }

    @Test
    public void cellOccupiedByNoughtReturnsNought() {
        cell.mark(playerNought);
        String noughtOccupiedCell = cell.getOccupant();
        assertEquals("O", noughtOccupiedCell);
    }
}