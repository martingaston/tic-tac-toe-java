import org.junit.Test;

import static org.junit.Assert.*;

public class MinimaxTest {
    private Node leftBranch;
    private Node rightBranch;
    private Node root;

    @Test
    public void testMinimaxForZeroAndZeroIsZero() {
        leftBranch = new Node(0);
        rightBranch = new Node(0);
        root = new Node(0, leftBranch, rightBranch);

        assertEquals(0, Minimax.optimal(root));
    }

    @Test
    public void testMinimaxForZeroAndOneIsOne() {
        leftBranch = new Node(0);
        rightBranch = new Node(1);
        root = new Node(0, leftBranch, rightBranch);

        assertEquals(1, Minimax.optimal(root));
    }

    @Test
    public void testMinimaxForOneAndFiveIsFive() {
        leftBranch = new Node(1);
        rightBranch = new Node(5);
        root = new Node(0, leftBranch, rightBranch);

        assertEquals(5, Minimax.optimal(root));
    }

    @Test
    public void testMinimaxForDepthOfTwoAndLeafsOfZeroAndOneReturnsZero() {
        leftBranch = new Node(0, new Node(0), new Node(1));
        rightBranch = new Node(0, new Node(0), new Node(1));
        root = new Node(0, leftBranch, rightBranch);

        assertEquals(0, Minimax.optimal(root));
    }

    @Test
    public void testMinimaxForDepthOfTwoAndLeafsOfOneAndTwoReturnsOne() {
        leftBranch = new Node(0, new Node(1), new Node(2));
        rightBranch = new Node(0, new Node(1), new Node(2));
        root = new Node(0, leftBranch, rightBranch);

        assertEquals(1, Minimax.optimal(root));
    }

    @Test
    public void testMinimaxForDepthOfTwoAndLeafsOfThreeFiveTwoAndNineReturnsThree() {
        leftBranch = new Node(0, new Node(3), new Node(5));
        rightBranch = new Node(0, new Node(2), new Node(9));
        root = new Node(0, leftBranch, rightBranch);

        assertEquals(3, Minimax.optimal(root));
    }
}