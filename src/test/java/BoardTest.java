import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
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
            currentCell = board.getCell(i);
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
        String cellOccupant = board.getCell(0).getOccupant();
        assertEquals(" ", cellOccupant);
    }

    @Test
    public void cellZeroShouldBeCrossWhenAddedToBoard() {
        board.addMove(0, playerCross);
        String cellOccupant = board.getCell(0).getOccupant();
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
        board.addMove(0, playerCross);
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
        board.addMove(0, playerCross);
        board.addMove(4, playerCross);
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
        board.addMove(1, playerNought);
        board.addMove(1, playerCross);
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
        board.addMove(4, playerCross);
        board.addMove(2, playerNought);
        board.addMove(3, playerCross);
        board.addMove(5, playerNought);
        board.addMove(0, playerCross);
        board.addMove(8, playerNought);
        board.addMove(4, playerCross);
        String[] updatedBoard = createStringArrayFromBoard(board);
        String[] expectedBoard = {
                "X", " ", "O",
                "X", "X", "O",
                " ", " ", "O"
        };
        assertArrayEquals(expectedBoard, updatedBoard);
    }

    @Test
    public void aBoardKnowsOfItsLines() {
        Board board = new Board(3);
        List<Board.Line> lines = board.lines();

        assertEquals(8, lines.size());
    }

    @Test
    public void findsTopHorizontalWinner() {
        Board board = new Board(3);
        board.addMove(0, playerCross);
        board.addMove(1, playerCross);
        board.addMove(2, playerCross);

        assertTrue(board.hasWinner());
    }

    @Test
    public void findsMiddleHorizontalWinner() {
        Board board = new Board(3);
        board.addMove(3, playerCross);
        board.addMove(4, playerCross);
        board.addMove(5, playerCross);

        assertTrue(board.hasWinner());
    }

    @Test
    public void findsBottomHorizontalWinner() {
        Board board = new Board(3);
        board.addMove(6, playerCross);
        board.addMove(7, playerCross);
        board.addMove(8, playerCross);

        assertTrue(board.hasWinner());
    }

    @Test
    public void findsLeftVerticalWinner() {
        Board board = new Board(3);
        board.addMove(0, playerCross);
        board.addMove(3, playerCross);
        board.addMove(6, playerCross);

        assertTrue(board.hasWinner());
    }

    @Test
    public void findsMiddleVerticalWinner() {
        Board board = new Board(3);
        board.addMove(1, playerCross);
        board.addMove(4, playerCross);
        board.addMove(7, playerCross);

        assertTrue(board.hasWinner());
    }

    @Test
    public void findsRightVerticalWinner() {
        Board board = new Board(3);
        board.addMove(2, playerCross);
        board.addMove(5, playerCross);
        board.addMove(8, playerCross);

        assertTrue(board.hasWinner());
    }

    @Test
    public void findsLeftDiagonalWinner() {
        Board board = new Board(3);
        board.addMove(0, playerCross);
        board.addMove(4, playerCross);
        board.addMove(8, playerCross);

        assertTrue(board.hasWinner());
    }

    @Test
    public void findsRightDiagonalWinner() {
        Board board = new Board(3);
        board.addMove(2, playerCross);
        board.addMove(4, playerCross);
        board.addMove(6, playerCross);

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
        board.addMove(0, playerCross);
        board.addMove(1, playerCross);
        board.addMove(2, playerCross);
        board.addMove(3, playerCross);
        board.addMove(4, playerCross);

        assertFalse(board.isGameOver());
    }

    @Test
    public void gameIsOverWithFullBoard() {
        Board board = new Board(3);
        board.addMove(0, playerCross);
        board.addMove(1, playerCross);
        board.addMove(2, playerCross);
        board.addMove(3, playerCross);
        board.addMove(4, playerCross);
        board.addMove(5, playerCross);
        board.addMove(6, playerCross);
        board.addMove(7, playerCross);
        board.addMove(8, playerCross);

        assertTrue(board.isGameOver());
    }
}