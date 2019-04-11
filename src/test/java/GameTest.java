import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class GameTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private final PrintStream originalOut = System.out;
    private Game game;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        game = new Game();
    }

    @After
    public void resetStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void shouldTakeUserInput() {
        game.play();
        String userInput = "4";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        //assertEquals("add 5", outContent.toString());
    }
}