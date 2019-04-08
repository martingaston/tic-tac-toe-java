import java.io.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class BoardTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Board board;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        board = new Board();
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testIsWorking() {
        assertEquals(42, 19 + 23);
    }

    @Test
    public void testXBoardRenders() {
        String[] boardState = {"X", "X", "X", "X", "X", "X", "X", "X", "X"};
        board.render(boardState);
        String boardExpected = "+-----------+\n| X | X | X |\n+-----------+\n| X | X | X |\n+-----------+\n| X | X | X |\n+-----------+\n";
        assertEquals(outContent.toString(), boardExpected);
    }

    @Test
    public void testOBoardRenders() {
        String[] boardState = {"O", "O", "O", "O", "O", "O", "O", "O", "O"};
        board.render(boardState);
        String boardExpected = "+-----------+\n| O | O | O |\n+-----------+\n| O | O | O |\n+-----------+\n| O | O | O |\n+-----------+\n";
        assertEquals(outContent.toString(), boardExpected);
    }
}