import org.junit.Test;

import static org.junit.Assert.*;

public class NodeSproutTest {
    @Test
    public void leafNodeReturnsValue() {
        NodeSprout<Integer> node = new NodeSprout<>(4);
        assertEquals(4, (int) node.getValue());
    }

    @Test
    public void leafNodeIsLeafReturnsTrue() {
        NodeSprout<Integer> node = new NodeSprout<>(4);
        assertTrue(node.isLeaf());
    }

    @Test
    public void branchNodeIsLeafReturnsFalse() {
        NodeSprout<Integer> left = new NodeSprout<>(1);
        NodeSprout<Integer> right = new NodeSprout<>(2);
        NodeSprout<Integer> node = new NodeSprout<>(3);
        node.addChild(left);
        node.addChild(right);

        assertFalse(node.isLeaf());
    }

    @Test
    public void branchNodeReturnsLeftLeaf() {
        NodeSprout<Integer> left = new NodeSprout<>(1);
        NodeSprout<Integer> right = new NodeSprout<>(2);
        NodeSprout<Integer> node = new NodeSprout<>(3);
        node.addChild(left);
        node.addChild(right);

        int leftChild = (int) node.getChild(0).getValue();

        assertEquals(1, leftChild);
    }

    @Test
    public void branchNodeReturnsRightLeaf() {
        NodeSprout<Integer> left = new NodeSprout<>(1);
        NodeSprout<Integer> right = new NodeSprout<>(2);
        NodeSprout<Integer> node = new NodeSprout<>(3);
        node.addChild(left);
        node.addChild(right);

        int leftChild = (int) node.getChild(1).getValue();

        assertEquals(2, leftChild);
    }
}