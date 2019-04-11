import java.io.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class BoardDisplayTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private BoardDisplay boardDisplay;

    @Before
    public void setUp() {
        boardDisplay = new BoardDisplay();
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
        String boardRendered = boardDisplay.render(boardState);
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
        String boardRendered = boardDisplay.render(boardState);
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
        String boardRendered = boardDisplay.render(boardState);
        boardDisplay.display(boardRendered);

        assertEquals(boardExpected, outContent.toString());
        System.setOut(originalOut);
    }
}