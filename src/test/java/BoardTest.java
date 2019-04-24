import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BoardTest {

    private Board board;
    private Player playerCross;
    private Player playerNought;

    private String[] createStringArrayFromBoard(Board board) {
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
        playerCross = new PlayerHuman("X");
        playerNought = new PlayerHuman("O");
    }

    @Test
    public void zeroArgumentBoardShouldTotalCellsShouldEqualNine() {
        assertEquals(9, board.getTotalCells());
    }

    @Test
    public void argumentOfFourToBoardShouldHaveTotalCellsEqualSixteen() {
        Board fourByFourBoard = new Board(4);
        assertEquals(16, fourByFourBoard.getTotalCells());
    }

    @Test
    public void cellZeroShouldBeBlankOnEmptyBoard() {
        String cellOccupant = board.getCellFromBoardPosition(0).getOccupant();
        assertEquals(" ", cellOccupant);
    }

    @Test
    public void cellZeroShouldBeCrossWhenAddedToBoard() {
        board.addMoveToBoard(0, playerCross);
        String cellOccupant = board.getCellFromBoardPosition(0).getOccupant();
        assertEquals("X", cellOccupant);
    }

    @Test
    public void newBoardShouldBeBlank() {
        String[] updatedBoard = createStringArrayFromBoard(board);
        String[] expectedBoard = {
                " ", " ", " ",
                " ", " ", " ",
                " ", " ", " "
        };
        assertArrayEquals(expectedBoard, updatedBoard);
    }

    @Test
    public void newFourByFourBoardShouldBeBlank() {
        Board fourByFourBoard = new Board(4);
        String[] updatedBoard = createStringArrayFromBoard(fourByFourBoard);
        String[] expectedBoard = {
                " ", " ", " ", " ",
                " ", " ", " ", " ",
                " ", " ", " ", " ",
                " ", " ", " ", " "
        };
        assertArrayEquals(expectedBoard, updatedBoard);
    }

    @Test
    public void UpdatedBoardShouldReturnCorrectBoardStateAfterOneMove() {
        board.addMoveToBoard(0, playerCross);
        String[] updatedBoard = createStringArrayFromBoard(board);
        String[] expectedBoard = {
                "X", " ", " ",
                " ", " ", " ",
                " ", " ", " "
        };
        assertArrayEquals(expectedBoard, updatedBoard);
    }

    @Test
    public void UpdatedBoardShouldReturnCorrectBoardStateAfterTwoMoves() {
        board.addMoveToBoard(0, playerCross);
        board.addMoveToBoard(4, playerCross);
        String[] updatedBoard = createStringArrayFromBoard(board);
        String[] expectedBoard = {
                "X", " ", " ",
                " ", "X", " ",
                " ", " ", " "
        };
        assertArrayEquals(expectedBoard, updatedBoard);
    }

    @Test
    public void UpdatedBoardShouldNotAllowOverwritingCells() {
        board.addMoveToBoard(1, playerNought);
        board.addMoveToBoard(1, playerCross);
        String[] updatedBoard = createStringArrayFromBoard(board);
        String[] expectedBoard = {
                " ", "O", " ",
                " ", " ", " ",
                " ", " ", " "
        };
        assertArrayEquals(expectedBoard, updatedBoard);
    }

    @Test
    public void UpdateBoardShouldBeAbleToRunEntireGame() {
        board.addMoveToBoard(4, playerCross);
        board.addMoveToBoard(2, playerNought);
        board.addMoveToBoard(3, playerCross);
        board.addMoveToBoard(5, playerNought);
        board.addMoveToBoard(0, playerCross);
        board.addMoveToBoard(8, playerNought);
        board.addMoveToBoard(4, playerCross);
        String[] updatedBoard = createStringArrayFromBoard(board);
        String[] expectedBoard = {
                "X", " ", "O",
                "X", "X", "O",
                " ", " ", "O"
        };
        assertArrayEquals(expectedBoard, updatedBoard);
    }

    @Test
    public void name() {
    }
}