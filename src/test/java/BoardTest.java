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
    public void setUp() {
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
    public void testBlankBoardRenders() {
        String[] boardState = {
                "", "", "",
                "", "", "",
                "", "", ""
        };
        String boardRendered = board.render(boardState);
        String boardExpected =
                "+-----------+\n" +
                "|   |   |   |\n" +
                "+-----------+\n" +
                "|   |   |   |\n" +
                "+-----------+\n" +
                "|   |   |   |\n" +
                "+-----------+\n";
        assertEquals(boardExpected, boardRendered);
    }

    @Test
    public void testXBoardRenders() {
        String[] boardState = {
                "X", "X", "X",
                "X", "X", "X",
                "X", "X", "X"
        };
        String boardRendered = board.render(boardState);
        String boardExpected =
                "+-----------+\n" +
                "| X | X | X |\n" +
                "+-----------+\n" +
                "| X | X | X |\n" +
                "+-----------+\n" +
                "| X | X | X |\n" +
                "+-----------+\n";
        assertEquals(boardExpected, boardRendered);
    }

    @Test
    public void testBoardPrints() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String boardExpected =
                "+-----------+\n" +
                "| X | O | X |\n" +
                "+-----------+\n" +
                "| O | X | O |\n" +
                "+-----------+\n" +
                "| X | O | X |\n" +
                "+-----------+\n";

        String[] boardState = {
                "X", "O", "X",
                "O", "X", "O",
                "X", "O", "X"
        };
        String boardRendered = board.render(boardState);
        board.display(boardRendered);

        assertEquals(boardExpected, outContent.toString());
        System.setOut(System.out);
    }
}