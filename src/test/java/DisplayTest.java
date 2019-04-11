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
    public void testMessagePrints() {
        String message = "Hello World!";
        String formattedMessage = message + "\n";
        Display.outMessage(message);
        assertEquals(formattedMessage, outContent.toString());
    }

}