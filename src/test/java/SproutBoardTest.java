import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SproutBoardTest {

    private SproutBoard board;
    private Player playerCross;
    private Player playerNought;

    private String[] createBoardArrayList() {
        ArrayList<String> boardAsArrayList = new ArrayList<>();
        int totalCells = 9;
        Cell currentCell;
        for (int i = 0; i < totalCells; i++) {
            currentCell = board.getCellFromBoardPosition(i);
            boardAsArrayList.add(currentCell.getOccupant());
        }
        return boardAsArrayList.toArray(new String[]{});
    }


    @Before
    public void setUp() {
        board = new SproutBoard();
        playerCross = new Player("X");
        playerNought = new Player("O");
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
        String[] updatedBoard = createBoardArrayList();
        String[] expectedBoard = {
                " ", " ", " ",
                " ", " ", " ",
                " ", " ", " "
        };
        assertArrayEquals(expectedBoard, updatedBoard);
    }

    @Test
    public void UpdatedBoardShouldReturnCorrectBoardStateAfterOneMove() {
        board.addMoveToBoard(0, playerCross);
        String[] updatedBoard = createBoardArrayList();
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
        String[] updatedBoard = createBoardArrayList();
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
        String[] updatedBoard = createBoardArrayList();
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
        String[] updatedBoard = createBoardArrayList();
        String[] expectedBoard = {
                "X", " ", "O",
                "X", "X", "O",
                " ", " ", "O"
        };
        assertArrayEquals(expectedBoard, updatedBoard);
    }
}