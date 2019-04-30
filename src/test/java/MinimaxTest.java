import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinimaxTest {
    private Node<Integer> leftBranch;
    private Node<Integer> rightBranch;
    private Node<Integer> root;

    @Test
    public void testMinimaxForZeroAndZeroIsZero() {
        leftBranch = new Node<>(0);
        rightBranch = new Node<>(0);
        root = new Node<>(0);
        root.addChild(leftBranch);
        root.addChild(rightBranch);

        assertEquals(0, Minimax.optimal(root));
    }

    @Test
    public void testMinimaxForZeroAndOneIsOne() {
        leftBranch = new Node<>(0);
        rightBranch = new Node<>(1);
        root = new Node<>(0);
        root.addChild(leftBranch);
        root.addChild(rightBranch);

        assertEquals(1, Minimax.optimal(root));
    }

    @Test
    public void testMinimaxForOneAndFiveIsFive() {
        leftBranch = new Node<>(1);
        rightBranch = new Node<>(5);
        root = new Node<>(0);
        root.addChild(leftBranch);
        root.addChild(rightBranch);

        assertEquals(5, Minimax.optimal(root));
    }

    @Test
    public void testMinimaxForDepthOfTwoAndLeafsOfZeroAndOneReturnsZero() {
        leftBranch = new Node<>(0);
        Node<Integer> leftBranchLeftLeaf = new Node<>(0);
        Node<Integer> leftBranchRightLeaf = new Node<>(1);
        leftBranch.addChild(leftBranchLeftLeaf);
        leftBranch.addChild(leftBranchRightLeaf);

        rightBranch = new Node<>(0);
        Node<Integer> rightBranchLeftLeaf = new Node<>(0);
        Node<Integer> rightBranchRightLeaf = new Node<>(1);
        rightBranch.addChild(rightBranchLeftLeaf);
        rightBranch.addChild(rightBranchRightLeaf);

        root = new Node<>(0);
        root.addChild(leftBranch);
        root.addChild(rightBranch);

        assertEquals(0, Minimax.optimal(root));
    }

    @Test
    public void testMinimaxForDepthOfTwoAndLeafsOfOneAndTwoReturnsOne() {
        leftBranch = new Node<>(0);
        Node<Integer> leftBranchLeftLeaf = new Node<>(1);
        Node<Integer> leftBranchRightLeaf = new Node<>(2);
        leftBranch.addChild(leftBranchLeftLeaf);
        leftBranch.addChild(leftBranchRightLeaf);

        rightBranch = new Node<>(0);
        Node<Integer> rightBranchLeftLeaf = new Node<>(1);
        Node<Integer> rightBranchRightLeaf = new Node<>(2);
        rightBranch.addChild(rightBranchLeftLeaf);
        rightBranch.addChild(rightBranchRightLeaf);

        root = new Node<>(0);
        root.addChild(leftBranch);
        root.addChild(rightBranch);

        assertEquals(1, Minimax.optimal(root));
    }

    @Test
    public void testMinimaxForDepthOfTwoAndLeafsOfThreeFiveTwoAndNineReturnsThree() {
        leftBranch = new Node<>(0);
        Node<Integer> leftBranchLeftLeaf = new Node<>(3);
        Node<Integer> leftBranchRightLeaf = new Node<>(5);
        leftBranch.addChild(leftBranchLeftLeaf);
        leftBranch.addChild(leftBranchRightLeaf);

        rightBranch = new Node<>(0);
        Node<Integer> rightBranchLeftLeaf = new Node<>(2);
        Node<Integer> rightBranchRightLeaf = new Node<>(9);
        rightBranch.addChild(rightBranchLeftLeaf);
        rightBranch.addChild(rightBranchRightLeaf);

        root = new Node<>(0);
        root.addChild(leftBranch);
        root.addChild(rightBranch);

        assertEquals(3, Minimax.optimal(root));
    }
}