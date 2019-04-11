import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.junit.experimental.runners.Enclosed;

import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class MessagesTest {

    public static class SpecificMessages {
        private Messages messages;
        private Player player;

        @Before
        public void setUp() {
            messages = new Messages();
            player = new Player("X");
        }

        @Test
        public void playerWinsIsFormattedBasedOnPlayerClass() {
            String expectedResult = "Player X wins!";
            String message = messages.get("gameOverWin", player);
            assertEquals(expectedResult, message);
        }

        @Test
        public void playerTurnIsFormattedBasedOnPlayerClass() {
            String expectedResult = "Player X's turn";
            String message = messages.get("playerTurn", player);
            assertEquals(expectedResult, message);
        }
    }

    @RunWith(Parameterized.class)
    public static class CheckLookupTypes {

        private boolean isString(String message) {
            return message.getClass() == String.class;
        }

        private Messages messages = new Messages();

        @Parameters
        public static Iterable<?> data() {
            return Arrays.asList("gameTitle", "gameIntro", "gameInstructions", "gameOverDraw");
        }

        @Parameter
        public String messageKey;

        @Test
        public void testMessageKeysReturnStrings() {
            String message = messages.get(messageKey);
            assertTrue(isString(message));
        }

        @Test
        public void testMessageKeyStringsAreNotEmpty() {
            String message = messages.get(messageKey);
            assertFalse(message.isEmpty());
        }
    }
}