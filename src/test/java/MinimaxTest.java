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

    @Test
    public void testMinimaxForDepthOfThreeReturnsFive() {
        Node<NodeValue> root = new Node<>(new NodeValue(0, 0));

        Node<NodeValue> depthOneBranchOne = new Node<>(new NodeValue(0, 0));

        Node<NodeValue> depthTwoBranchOne = new Node<>(new NodeValue(0, 0));

        Node<NodeValue> depthThreeLeaf1 = new Node<>(new NodeValue(2, 0));
        Node<NodeValue> depthThreeLeaf2 = new Node<>(new NodeValue(7, 0));

        depthTwoBranchOne.addChild(depthThreeLeaf1);
        depthTwoBranchOne.addChild(depthThreeLeaf2);
        
        Node<NodeValue> depthTwoBranchTwo = new Node<>(new NodeValue(0, 0));

        Node<NodeValue> depthThreeLeaf3 = new Node<>(new NodeValue(4, 0));
        Node<NodeValue> depthThreeLeaf4 = new Node<>(new NodeValue(1, 0));

        depthTwoBranchTwo.addChild(depthThreeLeaf3);
        depthTwoBranchTwo.addChild(depthThreeLeaf4);
        
        Node<NodeValue> depthTwoBranchThree = new Node<>(new NodeValue(0, 0));

        Node<NodeValue> depthThreeLeaf5 = new Node<>(new NodeValue(6, 0));
        Node<NodeValue> depthThreeLeaf6 = new Node<>(new NodeValue(11, 0));
        
        depthTwoBranchThree.addChild(depthThreeLeaf5);
        depthTwoBranchThree.addChild(depthThreeLeaf6);

        depthOneBranchOne.addChild(depthTwoBranchOne);
        depthOneBranchOne.addChild(depthTwoBranchTwo);
        depthOneBranchOne.addChild(depthTwoBranchThree);

        Node<NodeValue> depthOneBranchTwo = new Node<>(new NodeValue(0, 0));

        Node<NodeValue> depthTwoBranchFour = new Node<>(new NodeValue(0, 0));

        Node<NodeValue> depthThreeLeaf7 = new Node<>(new NodeValue(15, 0));
        Node<NodeValue> depthThreeLeaf8 = new Node<>(new NodeValue(9, 0));

        depthTwoBranchFour.addChild(depthThreeLeaf7);
        depthTwoBranchFour.addChild(depthThreeLeaf8);

        Node<NodeValue> depthTwoBranchFive = new Node<>(new NodeValue(0, 0));

        Node<NodeValue> depthThreeLeaf9 = new Node<>(new NodeValue(4, 0));
        Node<NodeValue> depthThreeLeaf10 = new Node<>(new NodeValue(2, 0));
        Node<NodeValue> depthThreeLeaf11 = new Node<>(new NodeValue(5, 0));

        depthTwoBranchFive.addChild(depthThreeLeaf9);
        depthTwoBranchFive.addChild(depthThreeLeaf10);
        depthTwoBranchFive.addChild(depthThreeLeaf11);

        depthOneBranchTwo.addChild(depthTwoBranchFour);
        depthOneBranchTwo.addChild(depthTwoBranchFive);

        root.addChild(depthOneBranchOne);
        root.addChild(depthOneBranchTwo);

        assertEquals(5, Minimax.optimal(root).score());
    }
}