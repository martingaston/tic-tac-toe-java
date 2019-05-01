import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RulesTest {
    private Board board;
    private Player playerCross;
    private Player playerNought;
    private Rules rules;

    @Before
    public void setUp() {
        board = new Board();
        rules = new Rules(board);
        playerCross = new PlayerHuman("X");
        playerNought = new PlayerHuman("O");
    }

    @Test
    public void testFourthCellIsValidMove() {
        assertFalse(rules.isNotValidMove(4));
    }

    @Test
    public void testEighthCellIsValidMove() {
        assertFalse(rules.isNotValidMove(8));
    }

    @Test
    public void testZeroCellIsValidMove() {
        assertFalse(rules.isNotValidMove(0));
    }

    @Test
    public void testMinusOneIsInvalidMove() {
        assertTrue(rules.isNotValidMove(-1));
    }

    @Test
    public void testNineIsInvalidMove() {
        assertTrue(rules.isNotValidMove(9));
    }

    @Test
    public void testOccupiedCellIsInvalidMove() {
        board.addMove(4, playerCross);
        assertTrue(rules.isNotValidMove(4));
    }

    @Test
    public void checkHorizontalTopIsValidWinCondition() {
        board.addMove(0, playerCross);
        board.addMove(1, playerCross);
        board.addMove(2, playerCross);
        assertTrue(rules.hasWinningMove(playerCross));

    }

    @Test
    public void checkHorizontalMiddleIsValidWinCondition() {
        board.addMove(3, playerCross);
        board.addMove(4, playerCross);
        board.addMove(5, playerCross);
        assertTrue(rules.hasWinningMove(playerCross));

    }

    @Test
    public void checkHorizontalBottomIsValidWinCondition() {
        board.addMove(6, playerCross);
        board.addMove(7, playerCross);
        board.addMove(8, playerCross);
        assertTrue(rules.hasWinningMove(playerCross));

    }

    @Test
    public void checkVerticalLeftIsValidWinCondition() {
        board.addMove(0, playerCross);
        board.addMove(3, playerCross);
        board.addMove(6, playerCross);
        assertTrue(rules.hasWinningMove(playerCross));
    }

    @Test
    public void checkVerticalMiddleIsValidWinCondition() {
        board.addMove(1, playerCross);
        board.addMove(4, playerCross);
        board.addMove(7, playerCross);
        assertTrue(rules.hasWinningMove(playerCross));
    }

    @Test
    public void checkVerticalRightIsValidWinCondition() {
        board.addMove(2, playerCross);
        board.addMove(5, playerCross);
        board.addMove(8, playerCross);
        assertTrue(rules.hasWinningMove(playerCross));
    }

    @Test
    public void checkLeftDiagonalIsValidWinCondition() {
        board.addMove(0, playerCross);
        board.addMove(4, playerCross);
        board.addMove(8, playerCross);
        assertTrue(rules.hasWinningMove(playerCross));
    }

    @Test
    public void checkRightDiagonalIsValidWinCondition() {
        board.addMove(2, playerCross);
        board.addMove(4, playerCross);
        board.addMove(6, playerCross);
        assertTrue(rules.hasWinningMove(playerCross));
    }

    @Test
    public void checkNoWinningHorizontalMoveReturnsFalse() {
        board.addMove(0, playerNought);
        board.addMove(2, playerNought);
        board.addMove(3, playerCross);
        board.addMove(4, playerCross);
        board.addMove(5, playerNought);
        board.addMove(6, playerNought);
        board.addMove(7, playerNought);
        board.addMove(8, playerCross);

        assertFalse(rules.hasWinningMove(playerCross));
    }

    @Test
    public void checkThatWinningMovesIsFalseIfOtherPlayerShouldWin() {
        board.addMove(0, playerNought);
        board.addMove(1, playerNought);
        board.addMove(2, playerNought);

        assertFalse(rules.hasWinningMove(playerCross));
    }

    @Test
    public void checkFullBoardReturnsGameOver() {
        board.addMove(0, playerNought);
        board.addMove(1, playerCross);
        board.addMove(2, playerNought);
        board.addMove(3, playerCross);
        board.addMove(4, playerCross);
        board.addMove(5, playerNought);
        board.addMove(6, playerNought);
        board.addMove(7, playerNought);
        board.addMove(8, playerCross);

        assertTrue(rules.gameIsOver());
    }

    @Test
    public void checkNotFullBoardDoesNotReturnGameOver() {
        board.addMove(0, playerNought);
        board.addMove(1, playerCross);
        board.addMove(3, playerCross);
        board.addMove(4, playerCross);
        board.addMove(5, playerNought);
        board.addMove(6, playerNought);
        board.addMove(7, playerNought);
        board.addMove(8, playerCross);

        assertFalse(rules.gameIsOver());
    }
}