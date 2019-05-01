import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @Test
    public void ListOfNodeValuesCanBeProperlySorted() {
        List<NodeValue> nodeValues = new ArrayList<>();
        nodeValues.add(new NodeValue(45, 0));
        nodeValues.add(new NodeValue(-5, 1));
        nodeValues.add(new NodeValue(42, 2));
        nodeValues.add(new NodeValue(-15, 3));

        nodeValues.sort(new NodeValueSort());
        assertEquals(-15, nodeValues.get(0).score());
        assertEquals(-5, nodeValues.get(1).score());
        assertEquals(42, nodeValues.get(2).score());
        assertEquals(45, nodeValues.get(3).score());
    }
}