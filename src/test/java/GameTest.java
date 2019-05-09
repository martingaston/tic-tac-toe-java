import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class GameTest {
    Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void parseArgsParsesValidModeArg() {
        Map<String, String> expectedArgs = new HashMap<>(Map.of("mode", "hvc-hard"));
        assertEquals(expectedArgs, game.parseArgs(new String[] {"--mode=hvc-hard"}));
    }

    @Test
    public void parseArgsParsesValidBoardArg() {
        Map<String, String> expectedArgs = new HashMap<>(Map.of("board", "4x4"));
        assertEquals(expectedArgs, game.parseArgs(new String[] {"--board=4x4"}));
    }

    @Test
    public void parseArgsParsesValidBoardAndModeArg() {
        Map<String, String> expectedArgs = new HashMap<>(Map.of("board", "4x4", "mode", "cvc"));
        assertEquals(expectedArgs, game.parseArgs(new String[] {"--mode=cvc", "--board=4x4"}));
    }
}