import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

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