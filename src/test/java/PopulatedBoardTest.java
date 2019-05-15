import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class PopulatedBoardTest {
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

    @Test
    public void boardFromListCreatesEmpty3x3Board() {
        FileState state = new FileState(Arrays.asList(
                "1", "1", "X", "O", "O",
                "", "", "",
                "", "", "",
                "", "", ""
        ));
        Board board = PopulatedBoard.from(state);
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
        FileState state = new FileState(Arrays.asList(
                "1", "1", "X", "O", "O",
                "X", "X", "X",
                "", "", "",
                "", "", ""
        ));
        Board board = PopulatedBoard.from(state);
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
        FileState state = new FileState(Arrays.asList(
                "1", "1", "X", "O", "O",
                "O", "", "",
                "O", "", "",
                "O", "", ""
        ));
        Board board = PopulatedBoard.from(state);
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
        FileState state = new FileState(Arrays.asList(
                "1", "1", "X", "O", "O",
                "Q", "Q", "Q",
                "", "", "",
                "", "", ""
        ));
        Board board = PopulatedBoard.from(state);
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
        FileState state = new FileState(Arrays.asList(
                "1", "1", "X", "O", "O",
                "", "", "", "",
                "", "", "", "",
                "", "", "", "",
                "", "", "", ""
        ));

        Board board = PopulatedBoard.from(state);
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
        FileState state = new FileState(Arrays.asList(
                "1", "1", "X", "O", "O",
                "X", "X", "X",
                "", "", "",
                "", "", "", ""
        ));

        Board board = PopulatedBoard.from(state);
        String[] updatedBoard = createStringArrayFromBoard(board);
        String[] expectedBoard = {
                " ", " ", " ",
                " ", " ", " ",
                " ", " ", " "
        };

        assertArrayEquals(expectedBoard, updatedBoard);
    }

}