import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class BoardDisplayTest {
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
}