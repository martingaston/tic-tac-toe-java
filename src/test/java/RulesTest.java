import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RulesTest {
    private Board board;
    private Player playerCross;
    private Player playerNought;
    private Rules rules;

    private String[] createStringArrayFromBoard() {
        ArrayList<String> boardAsArrayList = new ArrayList<>();
        int totalCells = board.getTotalCells();
        Cell currentCell;
        for (int i = 0; i < totalCells; i++) {
            currentCell = board.getCellFromBoardPosition(i);
            boardAsArrayList.add(currentCell.getOccupant());
        }
        return boardAsArrayList.toArray(new String[]{});
    }

    @Before
    public void setUp() {
        board = new Board();
        rules = new Rules(board);
        playerCross = new PlayerHuman("X");
        playerNought = new PlayerHuman("O");

    }

    @Test
    public void checkHorizontalTopIsValidWinCondition() {
        board.addMoveToBoard(0, playerCross);
        board.addMoveToBoard(1, playerCross);
        board.addMoveToBoard(2, playerCross);
        assertTrue(rules.hasWinningMove(playerCross));

    }

    @Test
    public void checkHorizontalMiddleIsValidWinCondition() {
        board.addMoveToBoard(3, playerCross);
        board.addMoveToBoard(4, playerCross);
        board.addMoveToBoard(5, playerCross);
        assertTrue(rules.hasWinningMove(playerCross));

    }

    @Test
    public void checkHorizontalBottomIsValidWinCondition() {
        board.addMoveToBoard(6, playerCross);
        board.addMoveToBoard(7, playerCross);
        board.addMoveToBoard(8, playerCross);
        assertTrue(rules.hasWinningMove(playerCross));

    }

    @Test
    public void checkVerticalLeftIsValidWinCondition() {
        board.addMoveToBoard(0, playerCross);
        board.addMoveToBoard(3, playerCross);
        board.addMoveToBoard(6, playerCross);
        assertTrue(rules.hasWinningMove(playerCross));
    }

    @Test
    public void checkVerticalMiddleIsValidWinCondition() {
        board.addMoveToBoard(1, playerCross);
        board.addMoveToBoard(4, playerCross);
        board.addMoveToBoard(7, playerCross);
        assertTrue(rules.hasWinningMove(playerCross));
    }

    @Test
    public void checkVerticalRightIsValidWinCondition() {
        board.addMoveToBoard(2, playerCross);
        board.addMoveToBoard(5, playerCross);
        board.addMoveToBoard(8, playerCross);
        assertTrue(rules.hasWinningMove(playerCross));
    }

    @Test
    public void checkLeftDiagonalIsValidWinCondition() {
        board.addMoveToBoard(0, playerCross);
        board.addMoveToBoard(4, playerCross);
        board.addMoveToBoard(8, playerCross);
        assertTrue(rules.hasWinningMove(playerCross));
    }

    @Test
    public void checkRightDiagonalIsValidWinCondition() {
        board.addMoveToBoard(2, playerCross);
        board.addMoveToBoard(4, playerCross);
        board.addMoveToBoard(6, playerCross);
        assertTrue(rules.hasWinningMove(playerCross));
    }

    @Test
    public void checkNoWinningHorizontalMoveReturnsFalse() {
        board.addMoveToBoard(0, playerNought);
        board.addMoveToBoard(2, playerNought);
        board.addMoveToBoard(3, playerCross);
        board.addMoveToBoard(4, playerCross);
        board.addMoveToBoard(5, playerNought);
        board.addMoveToBoard(6, playerNought);
        board.addMoveToBoard(7, playerNought);
        board.addMoveToBoard(8, playerCross);

        assertFalse(rules.hasWinningMove(playerCross));
    }

    @Test
    public void checkThatWinningMovesIsFalseIfOtherPlayerShouldWin() {
        board.addMoveToBoard(0, playerNought);
        board.addMoveToBoard(1, playerNought);
        board.addMoveToBoard(2, playerNought);

        assertFalse(rules.hasWinningMove(playerCross));
    }

    @Test
    public void checkFullBoardReturnsGameOver() {
        board.addMoveToBoard(0, playerNought);
        board.addMoveToBoard(1, playerCross);
        board.addMoveToBoard(2, playerNought);
        board.addMoveToBoard(3, playerCross);
        board.addMoveToBoard(4, playerCross);
        board.addMoveToBoard(5, playerNought);
        board.addMoveToBoard(6, playerNought);
        board.addMoveToBoard(7, playerNought);
        board.addMoveToBoard(8, playerCross);

        assertTrue(rules.gameIsOver());
    }

    @Test
    public void checkNotFullBoardDoesNotReturnGameOver() {
        board.addMoveToBoard(0, playerNought);
        board.addMoveToBoard(1, playerCross);
        board.addMoveToBoard(3, playerCross);
        board.addMoveToBoard(4, playerCross);
        board.addMoveToBoard(5, playerNought);
        board.addMoveToBoard(6, playerNought);
        board.addMoveToBoard(7, playerNought);
        board.addMoveToBoard(8, playerCross);

        assertFalse(rules.gameIsOver());
    }
}