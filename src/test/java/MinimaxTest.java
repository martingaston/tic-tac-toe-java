import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinimaxTest {
    private Board board;
    private Rules rules;
    private Player playerMaxi;
    private Player playerMini;
    private Minimax minimax;

    @Before
    public void setUp() throws Exception {
        board = new Board();
        rules = new Rules(board);
        playerMaxi = new PlayerHuman("Maxi");
        playerMini = new PlayerHuman("Mini");
        minimax = new Minimax(board, playerMaxi, playerMini);
    }
    @Test
    public void minimaxPlaysForWin() {
        board.add(0, playerMaxi);
        board.add(1, playerMaxi);
        int result = minimax.optimal();
        assertEquals(2, result);
    }

    @Test
    public void minimaxBlocksOpponentWin() {
        board.add(3, playerMini);
        board.add(4, playerMini);
        int result = minimax.optimal();
        assertEquals(5, result);
    }

    @Test
    public void minimaxGoesForEarliestWin() {
        board.add(0, playerMini);
        board.add(1, playerMini);
        board.add(2, playerMaxi);
        board.add(3, playerMini);
        board.add(4, playerMaxi);
        board.add(5, playerMaxi);
        int result = minimax.optimal();
        assertEquals(6, result);
    }
}