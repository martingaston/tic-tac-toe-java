import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void testPlayerSymbolCross() {
        Player player = new Player("X");
        assertEquals("X", player.getSymbol());
    }

    @Test
    public void testPlayerSymbolNought() {
        Player player = new Player("O");
        assertEquals("O", player.getSymbol());
    }
}