import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinimaxTest {
    Board board;
    Rules rules;
    Player playerMaxi;
    Player playerMini;
    Minimax minimax;

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
}