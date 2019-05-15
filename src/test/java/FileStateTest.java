import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FileStateTest {

    @Test
    public void GameStateReturnsModeHVHEnumWithOne() {
        List<String> stateVariables = Arrays.asList(
                "0", "1", "", "", "",
                "", "", "",
                "", "", "",
                "", "", "");
        FileState fileState = new FileState(stateVariables);
        assertEquals(GameModes.MODE_HVH, fileState.mode());
    }

    @Test
    public void GameStateReturnsModeHVCHardEnumWithThree() {
        List<String> stateVariables = Arrays.asList(
                "0", "3", "", "", "",
                "", "", "",
                "", "", "",
                "", "", "");
        FileState fileState = new FileState(stateVariables);
        assertEquals(GameModes.MODE_HVC_HARD, fileState.mode());
    }

    @Test
    public void GameStateReturnsModeHVHEnumIfInputIsInvalid() {
        List<String> stateVariables = Arrays.asList(
                "0", "15", "", "", "",
                "", "", "",
                "", "", "",
                "", "", "");
        FileState fileState = new FileState(stateVariables);
        assertEquals(GameModes.MODE_HVH, fileState.mode());
    }

    @Test
    public void GameStateReturnsBoard3X3EnumWithOne() {
        List<String> stateVariables = Arrays.asList(
                "1", "0", "", "", "",
                "", "", "",
                "", "", "",
                "", "", "");
        FileState fileState = new FileState(stateVariables);
        assertEquals(BoardModes.BOARD_3X3, fileState.board());
    }

    @Test
    public void GameStateReturnsBoard4X4EnumWithTwo() {
        List<String> stateVariables = Arrays.asList(
                "2", "0", "", "", "",
                "", "", "",
                "", "", "",
                "", "", "");
        FileState fileState = new FileState(stateVariables);
        assertEquals(BoardModes.BOARD_4X4, fileState.board());
    }

    @Test
    public void GameStateReturnsBoard3X3EnumWithInvalidInput() {
        List<String> stateVariables = Arrays.asList(
                "15", "0", "", "", "",
                "", "", "",
                "", "", "",
                "", "", "");
        FileState fileState = new FileState(stateVariables);
        assertEquals(BoardModes.BOARD_3X3, fileState.board());
    }
}