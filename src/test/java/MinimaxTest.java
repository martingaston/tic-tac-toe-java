import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimaxTest {
    private Board board;
    private Player playerMaxi;
    private Player playerMini;
    private Minimax minimax;

    @Before
    public void setUp() {
        board = new Board();
        playerMaxi = new PlayerHuman("Maxi");
        playerMini = new PlayerHuman("Mini");
        minimax = new Minimax(board, playerMaxi, playerMini);
    }

    @Test
    public void minimaxPlaysForWin() {
        board.add(0, playerMaxi.symbol());
        board.add(1, playerMaxi.symbol());
        int result = minimax.optimal();
        assertEquals(2, result);
    }

    @Test
    public void minimaxBlocksOpponentWin() {
        board.add(3, playerMini.symbol());
        board.add(4, playerMini.symbol());
        int result = minimax.optimal();
        assertEquals(5, result);
    }

    @Test
    public void minimaxGoesForEarliestWin() {
        board.add(0, playerMini.symbol());
        board.add(1, playerMini.symbol());
        board.add(2, playerMaxi.symbol());
        board.add(3, playerMini.symbol());
        board.add(4, playerMaxi.symbol());
        board.add(5, playerMaxi.symbol());
        int result = minimax.optimal();
        assertEquals(6, result);
    }
}