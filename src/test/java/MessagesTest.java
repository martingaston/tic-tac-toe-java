import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MessagesTest {
    private Messages messages;
    private Player player;
    private boolean isString(String message) {
        return message.getClass() == String.class;
    }

    @Before
    public void setUp() {
        messages = new Messages();
        player = new PlayerHuman("X");
    }

    @Test
    public void playerWinsIsFormattedBasedOnPlayerClass() {
        String expectedResult = "Player X wins!";
        String message = messages.playerWin(player);
        assertEquals(expectedResult, message);
    }

    @Test
    public void announcePlayerTurnIsFormattedBasedOnPlayerClass() {
        String expectedResult = "Player X's turn";
        String message = messages.announcePlayerTurn(player);
        assertEquals(expectedResult, message);
    }

    @Test
    public void playersDrawReturnsString() {
        String message = messages.playersDraw();
        assertTrue(isString(message));
    }

    @Test
    public void playersDrawStringIsNotEmpty() {
        String message = messages.playersDraw();
        assertFalse(message.isEmpty());
    }

    @Test
    public void getIntroReturnsString() {
        String message = messages.getIntro();
        assertTrue(isString(message));
    }

    @Test
    public void getIntroStringIsNotEmpty() {
        String message = messages.getIntro();
        assertFalse(message.isEmpty());
    }
}