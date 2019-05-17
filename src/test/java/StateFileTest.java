import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class StateFileTest {

    @Test
    public void gameStateReturnsModeHVHEnumWithOne() {
        List<String> stateVariables = Arrays.asList(
                "0", "1", "", "", "",
                "", "", "",
                "", "", "",
                "", "", "");
        StateFile stateFile = new StateFile(stateVariables);
        assertEquals(GameModes.MODE_HVH, stateFile.mode());
    }

    @Test
    public void gameStateReturnsModeHVCHardEnumWithThree() {
        List<String> stateVariables = Arrays.asList(
                "0", "3", "", "", "",
                "", "", "",
                "", "", "",
                "", "", "");
        StateFile stateFile = new StateFile(stateVariables);
        assertEquals(GameModes.MODE_HVC_HARD, stateFile.mode());
    }

    @Test
    public void gameStateReturnsModeHVHEnumIfInputIsInvalid() {
        List<String> stateVariables = Arrays.asList(
                "0", "15", "", "", "",
                "", "", "",
                "", "", "",
                "", "", "");
        StateFile stateFile = new StateFile(stateVariables);
        assertEquals(GameModes.MODE_HVH, stateFile.mode());
    }

    @Test
    public void gameStateReturnsBoard3X3EnumWithOne() {
        List<String> stateVariables = Arrays.asList(
                "1", "0", "", "", "",
                "", "", "",
                "", "", "",
                "", "", "");
        StateFile stateFile = new StateFile(stateVariables);
        assertEquals(BoardModes.BOARD_3X3, stateFile.boardMode());
    }

    @Test
    public void gameStateReturnsBoard4X4EnumWithTwo() {
        List<String> stateVariables = Arrays.asList(
                "2", "0", "", "", "",
                "", "", "",
                "", "", "",
                "", "", "");
        StateFile stateFile = new StateFile(stateVariables);
        assertEquals(BoardModes.BOARD_4X4, stateFile.boardMode());
    }

    @Test
    public void gameStateReturnsBoard3X3EnumWithInvalidInput() {
        List<String> stateVariables = Arrays.asList(
                "15", "0", "", "", "",
                "", "", "",
                "", "", "",
                "", "", "");
        StateFile stateFile = new StateFile(stateVariables);
        assertEquals(BoardModes.BOARD_3X3, stateFile.boardMode());
    }
}