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
        board.add(4, playerCross);
        assertTrue(rules.isNotValidMove(4));
    }

    @Test
    public void checkHorizontalTopIsValidWinCondition() {
        board.add(0, playerCross);
        board.add(1, playerCross);
        board.add(2, playerCross);
        assertTrue(rules.hasWinningMove(playerCross));

    }

    @Test
    public void checkHorizontalMiddleIsValidWinCondition() {
        board.add(3, playerCross);
        board.add(4, playerCross);
        board.add(5, playerCross);
        assertTrue(rules.hasWinningMove(playerCross));

    }

    @Test
    public void checkHorizontalBottomIsValidWinCondition() {
        board.add(6, playerCross);
        board.add(7, playerCross);
        board.add(8, playerCross);
        assertTrue(rules.hasWinningMove(playerCross));

    }

    @Test
    public void checkVerticalLeftIsValidWinCondition() {
        board.add(0, playerCross);
        board.add(3, playerCross);
        board.add(6, playerCross);
        assertTrue(rules.hasWinningMove(playerCross));
    }

    @Test
    public void checkVerticalMiddleIsValidWinCondition() {
        board.add(1, playerCross);
        board.add(4, playerCross);
        board.add(7, playerCross);
        assertTrue(rules.hasWinningMove(playerCross));
    }

    @Test
    public void checkVerticalRightIsValidWinCondition() {
        board.add(2, playerCross);
        board.add(5, playerCross);
        board.add(8, playerCross);
        assertTrue(rules.hasWinningMove(playerCross));
    }

    @Test
    public void checkLeftDiagonalIsValidWinCondition() {
        board.add(0, playerCross);
        board.add(4, playerCross);
        board.add(8, playerCross);
        assertTrue(rules.hasWinningMove(playerCross));
    }

    @Test
    public void checkRightDiagonalIsValidWinCondition() {
        board.add(2, playerCross);
        board.add(4, playerCross);
        board.add(6, playerCross);
        assertTrue(rules.hasWinningMove(playerCross));
    }

    @Test
    public void checkNoWinningHorizontalMoveReturnsFalse() {
        board.add(0, playerNought);
        board.add(2, playerNought);
        board.add(3, playerCross);
        board.add(4, playerCross);
        board.add(5, playerNought);
        board.add(6, playerNought);
        board.add(7, playerNought);
        board.add(8, playerCross);

        assertFalse(rules.hasWinningMove(playerCross));
    }

    @Test
    public void checkThatWinningMovesIsFalseIfOtherPlayerShouldWin() {
        board.add(0, playerNought);
        board.add(1, playerNought);
        board.add(2, playerNought);

        assertFalse(rules.hasWinningMove(playerCross));
    }

    @Test
    public void checkFullBoardReturnsGameOver() {
        board.add(0, playerNought);
        board.add(1, playerCross);
        board.add(2, playerNought);
        board.add(3, playerCross);
        board.add(4, playerCross);
        board.add(5, playerNought);
        board.add(6, playerNought);
        board.add(7, playerNought);
        board.add(8, playerCross);

        assertTrue(rules.gameIsOver());
    }

    @Test
    public void checkNotFullBoardDoesNotReturnGameOver() {
        board.add(0, playerNought);
        board.add(1, playerCross);
        board.add(3, playerCross);
        board.add(4, playerCross);
        board.add(5, playerNought);
        board.add(6, playerNought);
        board.add(7, playerNought);
        board.add(8, playerCross);

        assertFalse(rules.gameIsOver());
    }
}