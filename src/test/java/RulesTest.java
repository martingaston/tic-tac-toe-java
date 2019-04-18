import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RulesTest {
    private Rules rules;
    private Player player;
    private Board board;

    @Before
    public void setUp() {
        player = new Player("X");
    }

    @Test
    public void checkForBoardStateFromBoardClass() {
        String[] boardState = {
                "X", "X", "",
                "", "", "",
                "", "", ""
        };
        board = new Board(boardState);
        rules = new Rules(board);
        int boardPositionToUpdate = 2;
        board.addMoveToBoard(boardPositionToUpdate, player);
        assertTrue(rules.hasWinningMove(player));

    }

    @Test
    public void checkForBoardStateWithSpacesFromBoardClass() {
        String[] boardState = {
                "X", "X", " ",
                " ", " ", " ",
                " ", " ", " "
        };
        board = new Board(boardState);
        rules = new Rules(board);
        int boardPositionToUpdate = 2;
        board.addMoveToBoard(boardPositionToUpdate, player);
        assertTrue(rules.hasWinningMove(player));

    }

    @Test
    public void checkForWinningDiagonalLeftMove() {
        String[] boardState = {
                "X", " ", " ",
                " ", "X", " ",
                " ", " ", "X"
        };
        board = new Board(boardState);
        rules = new Rules(board);
        assertTrue(rules.hasWinningMove(player));
    }

    @Test
    public void checkForWinningDiagonalRightMove() {
        String[] boardState = {
                " ", " ", "X",
                " ", "X", " ",
                "X", " ", " "
        };
        board = new Board(boardState);
        rules = new Rules(board);
        assertTrue(rules.hasWinningMove(player));
    }

    @Test
    public void checkForWinningHorizontalTopMove() {
        String[] boardState = {
                "X", "X", "X",
                " ", " ", " ",
                " ", " ", " "
        };
        board = new Board(boardState);
        rules = new Rules(board);
        assertTrue(rules.hasWinningMove(player));
    }

    @Test
    public void checkForWinningHorizontalMiddleMove() {
        String[] boardState = {
                " ", " ", " ",
                "X", "X", "X",
                " ", " ", " "
        };
        board = new Board(boardState);
        rules = new Rules(board);
        assertTrue(rules.hasWinningMove(player));
    }

    @Test
    public void checkForWinningHorizontalBottomMove() {
        String[] boardState = {
                " ", " ", " ",
                " ", " ", " ",
                "X", "X", "X"
        };
        board = new Board(boardState);
        rules = new Rules(board);
        assertTrue(rules.hasWinningMove(player));
    }

    @Test
    public void checkForWinningVerticalLeftMove() {
        String[] boardState = {
                "X", " ", " ",
                "X", " ", " ",
                "X", " ", " "
        };
        board = new Board(boardState);
        rules = new Rules(board);
        assertTrue(rules.hasWinningMove(player));
    }

    @Test
    public void checkForWinningVerticalCenterMove() {
        String[] boardState = {
                " ", "X", " ",
                " ", "X", " ",
                " ", "X", " "
        };
        board = new Board(boardState);
        rules = new Rules(board);
        assertTrue(rules.hasWinningMove(player));
    }

    @Test
    public void checkForWinningVerticalRightMove() {
        String[] boardState = {
                " ", " ", "X",
                " ", " ", "X",
                " ", " ", "X"
        };
        board = new Board(boardState);
        rules = new Rules(board);
        assertTrue(rules.hasWinningMove(player));
    }

    @Test
    public void checkThatNoWinningVerticalMoveReturnsFalse() {
        String[] boardState = {
                "O", "X", "O",
                " ", "X", "O",
                "O", "O", "X"
        };
        board = new Board(boardState);
        rules = new Rules(board);
        assertFalse(rules.hasWinningMove(player));
    }

    @Test
    public void checkThatNoWinningHorizontalMoveReturnsFalse() {
        String[] boardState = {
                "O", " ", "O",
                "X", "X", "O",
                "O", "O", "X"
        };
        board = new Board(boardState);
        rules = new Rules(board);
        assertFalse(rules.hasWinningMove(player));
    }

    @Test
    public void checkThatWinningMovesIsFalseIfOtherPlayerShouldWin() {
        String[] boardState = {
                "O", "O", "O",
                "X", "X", "O",
                "O", "O", "X"
        };
        board = new Board(boardState);
        rules = new Rules(board);
        assertFalse(rules.hasWinningMove(player));
    }

    @Test
    public void checkThatBoardStateThatIsNotFullReturnsFalseOnGameIsOver() {
        String[] boardState = {
                " ", "X", " ",
                "O", " ", " ",
                " ", "X", " "
        };
        board = new Board(boardState);
        rules = new Rules(board);
        assertFalse(rules.gameIsOver());
    }

    @Test
    public void checkThatBoardStateThatIsFullReturnsTrueOnGameIsOverWithBoardClass() {
        String[] boardState = {
                "X", "X", "O",
                "O", "O", "X",
                "X", "X", "O"
        };
        board = new Board(boardState);
        rules = new Rules(board);
        assertTrue(rules.gameIsOver());
    }

    @Test
    public void checkThatBoardStateThatIsFullReturnsTrueOnGameIsOver() {
        String[] boardState = {
                "X", "X", "O",
                "O", "O", "X",
                "X", "X", "O"
        };
        board = new Board(boardState);
        rules = new Rules(board);
        assertTrue(rules.gameIsOver());
    }

    @Test
    public void checkThatBoardOfSpacesReturnsFalseOnGameIsOver() {
        String[] boardState = {
                " ", " ", " ",
                " ", " ", " ",
                " ", " ", " "
        };
        board = new Board(boardState);
        rules = new Rules(board);
        assertFalse(rules.gameIsOver());
    }
}