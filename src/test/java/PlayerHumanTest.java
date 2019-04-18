import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class PlayerHumanTest {
    Board board;
    Rules rules;

    @Before
    public void setUp() {
        board = new Board();
        rules = new Rules(board);
    }

    @Test
    public void testPlayerSymbolCross() {
        Player player = new PlayerHuman("X");
        assertEquals("X", player.getSymbol());
    }

    @Test
    public void testPlayerSymbolNought() {
        Player player = new PlayerHuman("O");
        assertEquals("O", player.getSymbol());
    }

    @Test
    public void testPlayerInput() {
        Player player = new PlayerHuman("O", rules);

        int zeroIndexedResult = 4;

        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(zeroIndexedResult, player.getNextMove());

    }


}