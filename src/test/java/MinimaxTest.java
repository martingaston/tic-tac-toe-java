import org.junit.Test;

import static org.junit.Assert.*;

public class MinimaxTest {
    @Test
    public void testMinimaxForZeroAndZeroIsZero() {
        int[] scores = { 0, 0 };
        assertEquals(0, Minimax.optimal(scores));
    }

    @Test
    public void testMinimaxForZeroAndOneIsOne() {
        int[] scores = { 0, 1 };
        assertEquals(1, Minimax.optimal(scores));
    }

    @Test
    public void testMinimaxForOneAndFiveIsFive() {
        int[] scores = { 1, 5 };
        assertEquals(5, Minimax.optimal(scores));
    }
}