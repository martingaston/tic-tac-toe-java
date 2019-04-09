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
        public void noArgumentReturnsEmptyString() {
            String expectedResult = "";
            String message = messages.get();
            assertEquals(expectedResult, message);
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
        @Parameters
        public static Iterable<?> data() {
            return Arrays.asList("gameTitle", "gameIntro", "gameInstructions", "gameOverDraw");
        }

        @Parameter
        public String messageKey;

        @Test
        public void testMessageKeysReturnStrings() {
            assertEquals(messageKey.getClass(), String.class);
        }

        @Test
        public void testMessageKeyStringsAreNotEmpty() {
            assertFalse(messageKey.isEmpty());
        }
    }
}