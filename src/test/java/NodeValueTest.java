import org.junit.Test;

import static org.junit.Assert.*;

public class NodeValueTest {
    @Test
    public void scoreOfNodeZeroZeroIsZero() {
        NodeValue nodeValue = new NodeValue(0, 0);
        assertEquals(0, nodeValue.score());
    }

    @Test
    public void positionOfNodeZeroZeroIsZero() {
        NodeValue nodeValue = new NodeValue(0, 0);
        assertEquals(0, nodeValue.position());
    }

    @Test
    public void scoreOfNodeMinusOneZeroIsMinusOne() {
        NodeValue nodeValue = new NodeValue(-1, 0);
        assertEquals(-1, nodeValue.score());
    }

    @Test
    public void positionOfNodeMinusOneEightIsEight() {
        NodeValue nodeValue = new NodeValue(-1, 8);
        assertEquals(8, nodeValue.position());
    }

    @Test
    public void scoreOfNodeSixtySixFourHundredIsSixtySix() {
        NodeValue nodeValue = new NodeValue(66, 400);
        assertEquals(66, nodeValue.score());
    }

    @Test
    public void positionOfNodeSixtySixFifteenIsFifteen() {
        NodeValue nodeValue = new NodeValue(66, 15);
        assertEquals(15, nodeValue.position());
    }
}