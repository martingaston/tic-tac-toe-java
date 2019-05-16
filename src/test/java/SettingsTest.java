import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class SettingsTest {
    @Test
    public void parseArgsParsesValidModeArg() {
        Map<String, String> expectedArgs = new HashMap<>(Map.of("mode", "hvc-hard"));
        assertEquals(expectedArgs, Settings.parseArgs(new String[] {"--mode=hvc-hard"}));
    }

    @Test
    public void parseArgsParsesValidBoardArg() {
        Map<String, String> expectedArgs = new HashMap<>(Map.of("board", "4x4"));
        assertEquals(expectedArgs, Settings.parseArgs(new String[] {"--board=4x4"}));
    }

    @Test
    public void parseArgsParsesValidBoardAndModeArg() {
        Map<String, String> expectedArgs = new HashMap<>(Map.of("board", "4x4", "mode", "cvc"));
        assertEquals(expectedArgs, Settings.parseArgs(new String[] {"--mode=cvc", "--board=4x4"}));
    }
}