import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PopulatedBoardTest {
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
        playerCross = new PlayerHuman("X");
        playerNought = new PlayerHuman("O");
    }

    @Test
    public void boardFromListCreatesEmpty3x3Board() {
        List<String> boardList = Arrays.asList("", "", "", "", "", "", "", "", "");
        Board board = PopulatedBoard.from(boardList, playerCross, playerNought);
        String[] updatedBoard = createStringArrayFromBoard(board);
        String[] expectedBoard = {
                " ", " ", " ",
                " ", " ", " ",
                " ", " ", " "
        };

        assertArrayEquals(expectedBoard, updatedBoard);
    }

    @Test
    public void boardFromListCreatesHorizontalPopulated3x3Board() {
        List<String> boardList = Arrays.asList("X", "X", "X", "", "", "", "", "", "");
        Board board = PopulatedBoard.from(boardList, playerCross, playerNought);
        String[] updatedBoard = createStringArrayFromBoard(board);
        String[] expectedBoard = {
                "X", "X", "X",
                " ", " ", " ",
                " ", " ", " "
        };

        assertArrayEquals(expectedBoard, updatedBoard);
    }

    @Test
    public void boardFromListCreatesVerticalPopulated3x3Board() {
        List<String> boardList = Arrays.asList("O", "", "", "O", "", "", "O", "", "");
        Board board = PopulatedBoard.from(boardList, playerCross, playerNought);
        String[] updatedBoard = createStringArrayFromBoard(board);
        String[] expectedBoard = {
                "O", " ", " ",
                "O", " ", " ",
                "O", " ", " "
        };

        assertArrayEquals(expectedBoard, updatedBoard);
    }

    @Test
    public void boardFromListDoesNotPlaceNonMatchingSymbols() {
        List<String> boardList = Arrays.asList("Q", "Q", "Q", "", "", "", "", "", "");
        Board board = PopulatedBoard.from(boardList, playerCross, playerNought);
        String[] updatedBoard = createStringArrayFromBoard(board);
        String[] expectedBoard = {
                " ", " ", " ",
                " ", " ", " ",
                " ", " ", " "
        };

        assertArrayEquals(expectedBoard, updatedBoard);
    }

    @Test
    public void boardFromListCreates4x4Board() {
        List<String> boardList = Arrays.asList(
                "", "", "", "",
                "", "", "", "",
                "", "", "", "",
                "", "", "", ""
        );

        Board board = PopulatedBoard.from(boardList, playerCross, playerNought);
        String[] updatedBoard = createStringArrayFromBoard(board);
        String[] expectedBoard = {
                " ", " ", " ", " ",
                " ", " ", " ", " ",
                " ", " ", " ", " ",
                " ", " ", " ", " "
        };

        assertArrayEquals(expectedBoard, updatedBoard);
    }

    @Test
    public void ListsNotNineOrSixteenLengthWillReturnEmpty3x3Board() {
        List<String> boardList = Arrays.asList(
                "", "", "", "",
                "", "", "", "",
                "", "", "", "",
                "", "", "X"
        );

        Board board = PopulatedBoard.from(boardList, playerCross, playerNought);
        String[] updatedBoard = createStringArrayFromBoard(board);
        String[] expectedBoard = {
                " ", " ", " ",
                " ", " ", " ",
                " ", " ", " "
        };

        assertArrayEquals(expectedBoard, updatedBoard);
    }

}