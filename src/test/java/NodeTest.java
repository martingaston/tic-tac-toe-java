import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {
    @Test
    public void leafNodeReturnsValue() {
        Node<Integer> node = new Node<>(4);
        assertEquals(4, (int) node.getValue());
    }

    @Test
    public void leafNodeIsLeafReturnsTrue() {
        Node<Integer> node = new Node<>(4);
        assertTrue(node.isLeaf());
    }

    @Test
    public void branchNodeIsLeafReturnsFalse() {
        Node<Integer> left = new Node<>(1);
        Node<Integer> right = new Node<>(2);
        Node<Integer> node = new Node<>(3);
        node.addChild(left);
        node.addChild(right);

        assertFalse(node.isLeaf());
    }

    @Test
    public void branchNodeReturnsLeftLeaf() {
        Node<Integer> left = new Node<>(1);
        Node<Integer> right = new Node<>(2);
        Node<Integer> node = new Node<>(3);
        node.addChild(left);
        node.addChild(right);

        int leftChild = node.getChild(0).getValue();

        assertEquals(1, leftChild);
    }

    @Test
    public void branchNodeReturnsRightLeaf() {
        Node<Integer> left = new Node<>(1);
        Node<Integer> right = new Node<>(2);
        Node<Integer> node = new Node<>(3);
        node.addChild(left);
        node.addChild(right);

        int leftChild = node.getChild(1).getValue();

        assertEquals(2, leftChild);
    }
}