import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayersTest {
    private Players players;

    @Before
    public void setUp() {
        Player playerCross = new Player("X");
        Player playerNought = new Player("O");
        players = new Players(playerCross, playerNought);
    }

    @Test
    public void getCurrentPlayerReturnsCrossOnFirstTurn() {
        Player currentPlayer = players.getCurrentPlayer();
        String currentPlayerSymbol = currentPlayer.getSymbol();
        assertEquals("X", currentPlayerSymbol);
    }

    @Test
    public void getCurrentPlayerReturnsNoughtAfterTurnChanges() {
        players.nextTurn();
        Player currentPlayer = players.getCurrentPlayer();
        String currentPlayerSymbol = currentPlayer.getSymbol();
        assertEquals("O", currentPlayerSymbol);
    }

    @Test
    public void getCurrentPlayerReturnsCrossAfterTwoTurns() {
        players.nextTurn();
        players.nextTurn();
        Player currentPlayer = players.getCurrentPlayer();
        String currentPlayerSymbol = currentPlayer.getSymbol();
        assertEquals("X", currentPlayerSymbol);
    }
}