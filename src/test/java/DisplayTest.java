import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class DisplayTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setupStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void resetStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testBoardPrints() {
        String board =
            "+-----------+\n" +
            "| X | O | X |\n" +
            "+-----------+\n" +
            "| O | X | O |\n" +
            "+-----------+\n" +
            "| X | O | X |\n" +
            "+-----------+\n";


        Display.outBoard(board);
        assertEquals(board, outContent.toString());
    }

    @Test
    public void testFullBoardStateOutputPrintsCorrectly() {
        String[] boardState = {
            "X", "O", "X",
            "O", "X", "O",
            "X", "O", "X"
        };

        String boardOutput =
            "+-----------+\n" +
            "| X | O | X |\n" +
            "+-----------+\n" +
            "| O | X | O |\n" +
            "+-----------+\n" +
            "| X | O | X |\n" +
            "+-----------+\n";
        Board board = new Board(boardState);
        Display display = new Display(board);
        display.showBoard();
        assertEquals(boardOutput, outContent.toString());
    }

    @Test
    public void testEmptyBoardStateOutputPrintsCorrectly() {
        String[] boardState = {
            "", "", "",
            "", "", "",
            "", "", ""
        };

        String boardOutput =
            "+-----------+\n" +
            "|   |   |   |\n" +
            "+-----------+\n" +
            "|   |   |   |\n" +
            "+-----------+\n" +
            "|   |   |   |\n" +
            "+-----------+\n";

        Board board = new Board(boardState);
        Display display = new Display(board);
        display.showBoard();
        assertEquals(boardOutput, outContent.toString());
    }

    @Test
    public void testMessagePrints() {
        String message = "Hello World!";
        String formattedMessage = message + "\n";
        Display.outMessage(message);
        assertEquals(formattedMessage, outContent.toString());
    }

}