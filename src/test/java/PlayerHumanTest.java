import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class PlayerHumanTest {
    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testPlayerSymbolCross() {
        Player player = new PlayerHuman("X", board);
        assertEquals("X", player.getSymbol());
    }

    @Test
    public void testPlayerSymbolNought() {
        Player player = new PlayerHuman("O", board);
        assertEquals("O", player.getSymbol());
    }

    @Test
    public void testPlayerInput() {
        Player player = new PlayerHuman("O", board);

        int zeroIndexedResult = 4;

        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(zeroIndexedResult, player.getNextMove());

    }


}