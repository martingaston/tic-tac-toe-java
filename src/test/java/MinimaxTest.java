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
        minimax = new Minimax(board, rules, playerMaxi, playerMini);
    }

    @Test
    public void WinStateReturns10() {
        board.addMove(0, playerMaxi);
        board.addMove(1, playerMaxi);
        board.addMove(2, playerMaxi);
        int result = minimax.minimax(0, false);
        assertEquals(10, result);
    }

    @Test
    public void LossStateReturnsMinus10() {
        board.addMove(0, playerMini);
        board.addMove(1, playerMini);
        board.addMove(2, playerMini);
        int result = minimax.minimax(0, false);
        assertEquals(-10, result);
    }

    @Test
    public void DrawReturnsZero() {
        board.addMove(0, playerMini);
        board.addMove(1, playerMaxi);
        board.addMove(2, playerMini);
        board.addMove(3, playerMaxi);
        board.addMove(4, playerMaxi);
        board.addMove(5, playerMini);
        board.addMove(6, playerMaxi);
        board.addMove(7, playerMini);
        board.addMove(8, playerMaxi);
        int result = minimax.minimax(0, false);
        assertEquals(0, result);
    }

    @Test
    public void minimaxPlaysForWin() {
        board.addMove(0, playerMaxi);
        board.addMove(1, playerMaxi);
        int result = minimax.optimal();
        assertEquals(2, result);
    }

    @Test
    public void minimaxBlocksOpponentWin() {
        board.addMove(3, playerMini);
        board.addMove(4, playerMini);
        int result = minimax.optimal();
        assertEquals(5, result);
    }

    @Test
    public void minimaxGoesForEarliestWin() {
        board.addMove(0, playerMini);
        board.addMove(1, playerMini);
        board.addMove(2, playerMaxi);
        board.addMove(3, playerMini);
        board.addMove(4, playerMaxi);
        board.addMove(5, playerMaxi);
        int result = minimax.optimal();
        assertEquals(6, result);
    }
}