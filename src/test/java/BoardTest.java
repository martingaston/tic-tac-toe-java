import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
            currentCell = board.get(i);
            boardAsArrayList.add(currentCell.getOccupant());
        }
        return boardAsArrayList.toArray(new String[]{});
    }


    @Before
    public void setUp() {
        board = new Board();
        playerCross = new PlayerHuman("X", board);
        playerNought = new PlayerHuman("O", board);
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
        String cellOccupant = board.get(0).getOccupant();
        assertEquals(" ", cellOccupant);
    }

    @Test
    public void cellZeroShouldBeCrossWhenAddedToBoard() {
        board.add(0, playerCross);
        String cellOccupant = board.get(0).getOccupant();
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
        board.add(0, playerCross);
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
        board.add(0, playerCross);
        board.add(4, playerCross);
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
        board.add(1, playerNought);
        board.add(1, playerCross);
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
        board.add(4, playerCross);
        board.add(2, playerNought);
        board.add(3, playerCross);
        board.add(5, playerNought);
        board.add(0, playerCross);
        board.add(8, playerNought);
        board.add(4, playerCross);
        String[] updatedBoard = createStringArrayFromBoard(board);
        String[] expectedBoard = {
                "X", " ", "O",
                "X", "X", "O",
                " ", " ", "O"
        };
        assertArrayEquals(expectedBoard, updatedBoard);
    }

    @Test
    public void emptyBoardReturnsNineAvailableCells() {
        assertEquals(9, board.available().size());
    }

    @Test
    public void halfFullBoardReturnsIndexesAvailable() {
        board.add(0, playerCross);
        board.add(1, playerNought);
        board.add(2, playerCross);
        board.add(3, playerNought);
        board.add(4, playerCross);
        List<Integer> result = board.available();
        List<Integer> expected = new ArrayList<>(Arrays.asList(5,6,7,8));
        assertEquals(expected, result);
    }

    @Test
    public void boardCanBeUnmarked() {
        board.add(0, playerCross);
        board.remove(0);
        assertEquals(9, board.available().size());
    }

    @Test
    public void availableReturnsSixIfThreeMovesArePlayed() {
        Board board = new Board(3);
        board.add(1, playerCross);
        board.add(2, playerNought);
        board.add(3, playerCross);

        assertEquals(6, board.available().size());
    }

    @Test
    public void availableReturnsArrayOfMoves() {
        Board board = new Board(3);
        board.add(0, playerCross);
        board.add(1, playerNought);
        board.add(2, playerCross);

        List<Integer> expected = new LinkedList<>(Arrays.asList(3,4,5,6,7,8));

        assertEquals(expected, board.available());
    }

    @Test
    public void aBoardKnowsOfItsLines() {
        Board board = new Board(3);
        List<Line> lines = board.lines();

        assertEquals(8, lines.size());
    }

    @Test
    public void doesNotFindWinnerIfNoWinner() {
        Board board = new Board(3);
        board.add(0, playerCross);
        board.add(1, playerCross);

        assertFalse(board.hasWinner());
    }

    @Test
    public void findsTopHorizontalWinner() {
        Board board = new Board(3);
        board.add(0, playerCross);
        board.add(1, playerCross);
        board.add(2, playerCross);

        assertTrue(board.hasWinner());
    }

    @Test
    public void findsMiddleHorizontalWinner() {
        Board board = new Board(3);
        board.add(3, playerCross);
        board.add(4, playerCross);
        board.add(5, playerCross);

        assertTrue(board.hasWinner());
    }

    @Test
    public void findsBottomHorizontalWinner() {
        Board board = new Board(3);
        board.add(6, playerCross);
        board.add(7, playerCross);
        board.add(8, playerCross);

        assertTrue(board.hasWinner());
    }

    @Test
    public void findsLeftVerticalWinner() {
        Board board = new Board(3);
        board.add(0, playerCross);
        board.add(3, playerCross);
        board.add(6, playerCross);

        assertTrue(board.hasWinner());
    }

    @Test
    public void findsMiddleVerticalWinner() {
        Board board = new Board(3);
        board.add(1, playerCross);
        board.add(4, playerCross);
        board.add(7, playerCross);

        assertTrue(board.hasWinner());
    }

    @Test
    public void findsRightVerticalWinner() {
        Board board = new Board(3);
        board.add(2, playerCross);
        board.add(5, playerCross);
        board.add(8, playerCross);

        assertTrue(board.hasWinner());
    }

    @Test
    public void findsLeftDiagonalWinner() {
        Board board = new Board(3);
        board.add(0, playerCross);
        board.add(4, playerCross);
        board.add(8, playerCross);

        assertTrue(board.hasWinner());
    }

    @Test
    public void findsRightDiagonalWinner() {
        Board board = new Board(3);
        board.add(2, playerCross);
        board.add(4, playerCross);
        board.add(6, playerCross);

        assertTrue(board.hasWinner());
    }

    @Test
    public void gameIsNotOverWithEmptyBoard() {
        Board board = new Board(3);

        assertFalse(board.isGameOver());
    }

    @Test
    public void gameIsNotOverWithHalfFullBoard() {
        Board board = new Board(3);
        board.add(0, playerCross);
        board.add(1, playerNought);
        board.add(2, playerCross);
        board.add(3, playerNought);

        assertFalse(board.isGameOver());
    }

    @Test
    public void gameIsOverWithFullBoard() {
        Board board = new Board(3);
        board.add(0, playerCross);
        board.add(1, playerCross);
        board.add(2, playerCross);
        board.add(3, playerCross);
        board.add(4, playerCross);
        board.add(5, playerCross);
        board.add(6, playerCross);
        board.add(7, playerCross);
        board.add(8, playerCross);

        assertTrue(board.isGameOver());
    }
}