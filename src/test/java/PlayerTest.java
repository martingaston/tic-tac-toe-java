import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void testPlayerSymbolX() {
        Player player = new Player("X");
        String playerSymbol = player.getSymbol();
        String expectedPlayerSymbol = "X";
        assertEquals(expectedPlayerSymbol, playerSymbol);
    }

    @Test
    public void testPlayerSymbolO() {
        Player player = new Player("O");
        String playerSymbol = player.getSymbol();
        String expectedPlayerSymbol = "O";
        assertEquals(expectedPlayerSymbol, playerSymbol);
    }
}