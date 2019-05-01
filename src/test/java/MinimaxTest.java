import org.junit.Test;

import static org.junit.Assert.*;

public class MinimaxTest {
    private Node<NodeValue> leftBranch;
    private Node<NodeValue> rightBranch;
    private Node<NodeValue> root;

    @Test
    public void testMinimaxForZeroAndZeroIsZero() {
        leftBranch = new Node<>(new NodeValue(0, 0));
        rightBranch = new Node<>(new NodeValue(0, 0));
        root = new Node<>(new NodeValue(0, 0));
        root.addChild(leftBranch);
        root.addChild(rightBranch);

        assertEquals(0, Minimax.optimal(root).score());
    }

    @Test
    public void testMinimaxForZeroAndOneIsOne() {
        leftBranch = new Node<>(new NodeValue(0, 0));
        rightBranch = new Node<>(new NodeValue(1, 0));
        root = new Node<>(new NodeValue(0, 0));
        root.addChild(leftBranch);
        root.addChild(rightBranch);

        assertEquals(1, Minimax.optimal(root).score());
    }

    @Test
    public void testMinimaxForOneAndFiveIsFive() {
        leftBranch = new Node<>(new NodeValue(1, 0));
        rightBranch = new Node<>(new NodeValue(5, 0));
        root = new Node<>(new NodeValue(0, 0));
        root.addChild(leftBranch);
        root.addChild(rightBranch);

        assertEquals(5, Minimax.optimal(root).score());
    }

    @Test
    public void testMinimaxForDepthOfTwoAndLeafsOfZeroAndOneReturnsZero() {
        leftBranch = new Node<>(new NodeValue(0, 0));
        Node<NodeValue> leftBranchLeftLeaf = new Node<>(new NodeValue(0, 0));
        Node<NodeValue> leftBranchRightLeaf = new Node<>(new NodeValue(1, 0));
        leftBranch.addChild(leftBranchLeftLeaf);
        leftBranch.addChild(leftBranchRightLeaf);

        rightBranch = new Node<>(new NodeValue(0, 0));
        Node<NodeValue> rightBranchLeftLeaf = new Node<>(new NodeValue(0, 0));
        Node<NodeValue> rightBranchRightLeaf = new Node<>(new NodeValue(1, 0));
        rightBranch.addChild(rightBranchLeftLeaf);
        rightBranch.addChild(rightBranchRightLeaf);

        root = new Node<>(new NodeValue(0, 0));
        root.addChild(leftBranch);
        root.addChild(rightBranch);

        assertEquals(0, Minimax.optimal(root).score());
    }

    @Test
    public void testMinimaxForDepthOfTwoAndLeafsOfOneAndTwoReturnsOne() {
        leftBranch = new Node<>(new NodeValue(0, 0));
        Node<NodeValue> leftBranchLeftLeaf = new Node<>(new NodeValue(1, 0));
        Node<NodeValue> leftBranchRightLeaf = new Node<>(new NodeValue(2, 0));
        leftBranch.addChild(leftBranchLeftLeaf);
        leftBranch.addChild(leftBranchRightLeaf);

        rightBranch = new Node<>(new NodeValue(0, 0));
        Node<NodeValue> rightBranchLeftLeaf = new Node<>(new NodeValue(1, 0));
        Node<NodeValue> rightBranchRightLeaf = new Node<>(new NodeValue(2, 0));
        rightBranch.addChild(rightBranchLeftLeaf);
        rightBranch.addChild(rightBranchRightLeaf);

        root = new Node<>(new NodeValue(0, 0));
        root.addChild(leftBranch);
        root.addChild(rightBranch);

        assertEquals(1, Minimax.optimal(root).score());
    }

    @Test
    public void testMinimaxForDepthOfTwoAndLeafsOfThreeFiveTwoAndNineReturnsThree() {
        leftBranch = new Node<>(new NodeValue(0, 0));
        Node<NodeValue> leftBranchLeftLeaf = new Node<>(new NodeValue(3, 0));
        Node<NodeValue> leftBranchRightLeaf = new Node<>(new NodeValue(5, 0));
        leftBranch.addChild(leftBranchLeftLeaf);
        leftBranch.addChild(leftBranchRightLeaf);

        rightBranch = new Node<>(new NodeValue(0, 0));
        Node<NodeValue> rightBranchLeftLeaf = new Node<>(new NodeValue(2, 0));
        Node<NodeValue> rightBranchRightLeaf = new Node<>(new NodeValue(9, 0));
        rightBranch.addChild(rightBranchLeftLeaf);
        rightBranch.addChild(rightBranchRightLeaf);

        root = new Node<>(new NodeValue(0, 0));
        root.addChild(leftBranch);
        root.addChild(rightBranch);

        assertEquals(3, Minimax.optimal(root).score());
    }


}