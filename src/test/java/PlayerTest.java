import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class PlayerTest {
    private Board board;
    private Rules rules;

    @Before
    public void setUp() {
        board = new Board();
        rules = new Rules(board);
    }

    @Test
    public void testPlayerSymbolCross() {
        Player player = new Player("X", rules);
        assertEquals("X", player.getSymbol());
    }

    @Test
    public void testPlayerSymbolNought() {
        Player player = new Player("O", rules);
        assertEquals("O", player.getSymbol());
    }

    @Test
    public void testPlayerInput() {
        Player player = new Player("O", rules);

        int expectedResult = 5;

        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(expectedResult, player.getNextMove());

    }


}