import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void parseArgsParsesValidModeArg() {
        Map<String, String> expectedArgs = new HashMap<>(Map.of("mode", "hvc-hard"));
        assertEquals(expectedArgs, Game.parseArgs(new String[] {"--mode=hvc-hard"}));
    }

    @Test
    public void parseArgsParsesValidBoardArg() {
        Map<String, String> expectedArgs = new HashMap<>(Map.of("board", "4x4"));
        assertEquals(expectedArgs, Game.parseArgs(new String[] {"--board=4x4"}));
    }

    @Test
    public void parseArgsParsesValidBoardAndModeArg() {
        Map<String, String> expectedArgs = new HashMap<>(Map.of("board", "4x4", "mode", "cvc"));
        assertEquals(expectedArgs, Game.parseArgs(new String[] {"--mode=cvc", "--board=4x4"}));
    }
}