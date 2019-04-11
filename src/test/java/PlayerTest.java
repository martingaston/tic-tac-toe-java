import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

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

    @Test
    public void testPlayerInput() {
        Player player = new Player("O");

        int expectedResult = 5;

        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(expectedResult, player.getNextMove());

    }


}