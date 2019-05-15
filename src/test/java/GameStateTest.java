import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GameStateTest {

    @Test
    public void GameStateReturnsModeHVHEnumWithOne() {
        List<String> stateVariables = Arrays.asList(
                "0", "1", "", "", "",
                "", "", "",
                "", "", "",
                "", "", "");
        GameState gameState = new GameState(stateVariables);
        assertEquals(GameConstants.MODE_HVH, gameState.mode());
    }

    @Test
    public void GameStateReturnsModeHVCHardEnumWithThree() {
        List<String> stateVariables = Arrays.asList(
                "0", "3", "", "", "",
                "", "", "",
                "", "", "",
                "", "", "");
        GameState gameState = new GameState(stateVariables);
        assertEquals(GameConstants.MODE_HVC_HARD, gameState.mode());
    }

    @Test
    public void GameStateReturnsModeHVHEnumIfInputIsInvalid() {
        List<String> stateVariables = Arrays.asList(
                "0", "15", "", "", "",
                "", "", "",
                "", "", "",
                "", "", "");
        GameState gameState = new GameState(stateVariables);
        assertEquals(GameConstants.MODE_HVH, gameState.mode());
    }

    @Test
    public void GameStateReturnsBoard3X3EnumWithOne() {
        List<String> stateVariables = Arrays.asList(
                "1", "0", "", "", "",
                "", "", "",
                "", "", "",
                "", "", "");
        GameState gameState = new GameState(stateVariables);
        assertEquals(GameConstants.BOARD_3X3, gameState.board());
    }

    @Test
    public void GameStateReturnsBoard4X4EnumWithTwo() {
        List<String> stateVariables = Arrays.asList(
                "2", "0", "", "", "",
                "", "", "",
                "", "", "",
                "", "", "");
        GameState gameState = new GameState(stateVariables);
        assertEquals(GameConstants.BOARD_4X4, gameState.board());
    }

    @Test
    public void GameStateReturnsBoard3X3EnumWithInvalidInput() {
        List<String> stateVariables = Arrays.asList(
                "15", "0", "", "", "",
                "", "", "",
                "", "", "",
                "", "", "");
        GameState gameState = new GameState(stateVariables);
        assertEquals(GameConstants.BOARD_3X3, gameState.board());
    }
}