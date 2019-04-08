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
    public void testBoardRenders() {
        board.render();
        String boardExpected = "+-----------+\n| X | X | X |\n+-----------+\n| X | X | X |\n+-----------+\n| X | X | X |\n+-----------+\n";
        assertEquals(outContent.toString(), boardExpected);
    }

    @Test
    public void testPrintLn() {
        String helloTextExpected = "Hello World!\n";
        board.hello();
        assertEquals(outContent.toString(), helloTextExpected);
    }
    
    @Test
    public void testBoardAdd() {
        Integer boardSum = board.sum(40, 2);
        Integer expectedSum = 42;
        assertEquals(boardSum, expectedSum);
    }
}