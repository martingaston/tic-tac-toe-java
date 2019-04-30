import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {
    @Test
    public void leafNodeReturnsValue() {
        Node node = new Node(4);
        assertEquals(4, node.getValue());
    }

    @Test
    public void leafNodeIsLeafReturnsTrue() {
        Node node = new Node(4);
        assertTrue(node.isLeaf());
    }

    @Test
    public void branchNodeIsLeafReturnsFalse() {
        Node left = new Node(1);
        Node right = new Node(2);
        Node node = new Node(3, left, right);

        assertFalse(node.isLeaf());
    }

    @Test
    public void branchNodeReturnsRightLeaf() {
        Node left = new Node(1);
        Node right = new Node(2);
        Node node = new Node(3, left, right);

        assertEquals(2, node.getRightNode().getValue());
    }
}