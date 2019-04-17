import org.junit.Test;

import static org.junit.Assert.*;

public class ColourTest {
    @Test
    public void name() {
        String colourisedString = Colour.faded("Hello World!");
        assertEquals(colourisedString, "\033[38;5;242mHello World!\033[0m");
    }
}