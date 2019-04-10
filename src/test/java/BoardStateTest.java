import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardStateTest {
    private BoardState boardState;
    private Player playerCross;
    private Player playerNought;

    @Before
    public void setUp() {
        boardState = new BoardState();
        playerCross = new Player("X");
        playerNought = new Player("O");
    }

    @Test
    public void CreateBoardShouldReturnBlankBoard() {
        String[] createdBoard = boardState.getCurrentBoard();
        String[] expectedBoard = {
                "", "", "",
                "", "", "",
                "", "", ""
        };
        assertArrayEquals(expectedBoard, createdBoard);
    }

    @Test
    public void UpdatedBoardShouldReturnCorrectBoardStateAfterOneMove() {
        String[] updatedBoard = boardState.updateBoard(0, playerCross);
        String[] expectedBoard = {
                "X", "", "",
                "", "", "",
                "", "", ""
        };
        assertArrayEquals(expectedBoard, updatedBoard);
    }

    @Test
    public void UpdatedBoardShouldReturnCorrectBoardStateAfterTwoMoves() {
        boardState.updateBoard(0, playerCross);
        String[] updatedBoard = boardState.updateBoard(4, playerCross);
        String[] expectedBoard = {
                "X", "", "",
                "", "X", "",
                "", "", ""
        };
        assertArrayEquals(expectedBoard, updatedBoard);
    }

    @Test
    public void UpdatedBoardShouldNotAllowOverwritingCells() {
        boardState.updateBoard(1, playerNought);
        String[] updatedBoard = boardState.updateBoard(1, playerCross);
        String[] expectedBoard = {
                "", "O", "",
                "", "", "",
                "", "", ""
        };
        assertArrayEquals(expectedBoard, updatedBoard);
    }

    @Test
    public void UpdateBoardShouldBeAbleToRunEntireGame() {
        boardState.updateBoard(4, playerCross);
        boardState.updateBoard(2, playerNought);
        boardState.updateBoard(3, playerCross);
        boardState.updateBoard(5, playerNought);
        boardState.updateBoard(0, playerCross);
        boardState.updateBoard(8, playerNought);
        String[] updatedBoard = boardState.updateBoard(4, playerCross);
        String[] expectedBoard = {
                "X", "", "O",
                "X", "X", "O",
                "", "", "O"
        };
        assertArrayEquals(expectedBoard, updatedBoard);
    }
}