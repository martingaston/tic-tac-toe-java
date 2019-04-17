import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    private Board board;
    private Player playerCross;
    private Player playerNought;

    @Before
    public void setUp() {
        board = new Board();
        playerCross = new Player("X");
        playerNought = new Player("O");
    }

    @Test
    public void createBoardShouldReturnBlankBoard() {
        String[] createdBoard = board.getCurrentBoard();
        String[] expectedBoard = {
                "", "", "",
                "", "", "",
                "", "", ""
        };
        assertArrayEquals(expectedBoard, createdBoard);
    }

    @Test
    public void updatedBoardShouldReturnCorrectBoardStateAfterOneMove() {
        String[] updatedBoard = board.addMoveToBoard(0, playerCross);
        String[] expectedBoard = {
                "X", "", "",
                "", "", "",
                "", "", ""
        };
        assertArrayEquals(expectedBoard, updatedBoard);
    }

    @Test
    public void updatedBoardShouldReturnCorrectBoardStateAfterTwoMoves() {
        board.addMoveToBoard(0, playerCross);
        String[] updatedBoard = board.addMoveToBoard(4, playerCross);
        String[] expectedBoard = {
                "X", "", "",
                "", "X", "",
                "", "", ""
        };
        assertArrayEquals(expectedBoard, updatedBoard);
    }

    @Test
    public void updatedBoardShouldNotAllowOverwritingCells() {
        board.addMoveToBoard(1, playerNought);
        String[] updatedBoard = board.addMoveToBoard(1, playerCross);
        String[] expectedBoard = {
                "", "O", "",
                "", "", "",
                "", "", ""
        };
        assertArrayEquals(expectedBoard, updatedBoard);
    }

    @Test
    public void updateBoardShouldBeAbleToRunEntireGame() {
        board.addMoveToBoard(4, playerCross);
        board.addMoveToBoard(2, playerNought);
        board.addMoveToBoard(3, playerCross);
        board.addMoveToBoard(5, playerNought);
        board.addMoveToBoard(0, playerCross);
        board.addMoveToBoard(8, playerNought);
        String[] updatedBoard = board.addMoveToBoard(4, playerCross);
        String[] expectedBoard = {
                "X", "", "O",
                "X", "X", "O",
                "", "", "O"
        };
        assertArrayEquals(expectedBoard, updatedBoard);
    }
}