import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeTest {
    private Board board;
    private Rules rules;
    private Players players;
    private Player playerCross;
    private Player playerNought;

    @Before
    public void setUp() throws Exception {
        board = new Board();
        rules = new Rules(board);

        playerCross = new PlayerHuman("X");
        playerNought = new PlayerHuman("O");
        players = new Players(playerCross, playerNought);
    }

    @Test
    public void drawStateReturnsNodeWithZeroValue() {
        board.addMoveToBoard(0, playerCross);
        board.addMoveToBoard(1, playerCross);
        board.addMoveToBoard(2, playerNought);
        board.addMoveToBoard(3, playerNought);
        board.addMoveToBoard(4, playerCross);
        board.addMoveToBoard(6, playerCross);
        board.addMoveToBoard(7, playerNought);
        board.addMoveToBoard(8, playerNought);

        Node<NodeValue> node = Tree.makeNode(board, rules, playerCross, players);
        assertEquals(0, node.getValue().score());
    }

    @Test
    public void winStateReturnsNodeWithOneValue() {
        board.addMoveToBoard(0, playerCross);
        board.addMoveToBoard(1, playerNought);
        board.addMoveToBoard(2, playerCross);
        board.addMoveToBoard(3, playerNought);
        board.addMoveToBoard(4, playerNought);
        board.addMoveToBoard(5, playerCross);
        board.addMoveToBoard(6, playerNought);
        board.addMoveToBoard(7, playerCross);

        Node<NodeValue> node = Tree.makeNode(board, rules, playerCross, players);
        assertEquals(1, node.getValue().score());
    }

    @Test
    public void losingStateReturnsNodeWithMinusOneValue() {
        board.addMoveToBoard(0, playerCross);
        board.addMoveToBoard(1, playerNought);
        board.addMoveToBoard(2, playerCross);
        board.addMoveToBoard(3, playerNought);
        board.addMoveToBoard(4, playerNought);
        board.addMoveToBoard(5, playerCross);
        board.addMoveToBoard(6, playerNought);
        board.addMoveToBoard(7, playerCross);

        Node<NodeValue> node = Tree.makeNode(board, rules, playerNought, players);
        assertEquals(-1, node.getValue().score());
    }

    @Test
    public void drawStateReturnsTreeWithTwoChildren() {
        board.addMoveToBoard(0, playerNought);
        board.addMoveToBoard(1, playerNought);
        board.addMoveToBoard(2, playerCross);
        board.addMoveToBoard(3, playerNought);
        board.addMoveToBoard(4, playerCross);
        board.addMoveToBoard(5, playerCross);
        board.addMoveToBoard(7, playerCross);
        players.nextTurn();

        Node node = Tree.makeNode(board, rules, playerCross, players);
        assertEquals(2, node.size());
    }

    @Test
    public void drawStateReturnsTreeWithTwoChildrenAndFirstChildIsLoss() {
        board.addMoveToBoard(0, playerNought);
        board.addMoveToBoard(1, playerNought);
        board.addMoveToBoard(2, playerCross);
        board.addMoveToBoard(3, playerNought);
        board.addMoveToBoard(4, playerCross);
        board.addMoveToBoard(5, playerCross);
        board.addMoveToBoard(7, playerCross);
        players.nextTurn();

        Node<NodeValue> node = Tree.makeNode(board, rules, playerCross, players);
        int loss = -1;
        assertEquals(loss, node.getChild(0).getValue().score());
    }

    @Test
    public void drawStateReturnsTreeWithTwoChildrenAndSecondChildIsNotLeaf() {
        board.addMoveToBoard(0, playerNought);
        board.addMoveToBoard(1, playerNought);
        board.addMoveToBoard(2, playerCross);
        board.addMoveToBoard(3, playerNought);
        board.addMoveToBoard(4, playerCross);
        board.addMoveToBoard(5, playerCross);
        board.addMoveToBoard(7, playerCross);
        players.nextTurn();

        Node node = Tree.makeNode(board, rules, playerCross, players);
        assertFalse(node.getChild(1).isLeaf());
    }

    @Test
    public void drawStateReturnsTreeWithTwoChildrenAndSecondChildValueIsOne() {
        board.addMoveToBoard(0, playerNought);
        board.addMoveToBoard(1, playerNought);
        board.addMoveToBoard(2, playerCross);
        board.addMoveToBoard(3, playerNought);
        board.addMoveToBoard(4, playerCross);
        board.addMoveToBoard(5, playerCross);
        board.addMoveToBoard(7, playerCross);
        players.nextTurn();

        int win = 1;

        Node<NodeValue> node = Tree.makeNode(board, rules, playerCross, players);
        assertEquals(win, node.getChild(1).getChild(0).getValue().score());
    }

    @Test
    public void minimaxReturnsOneOnTreeWithTwoChildrenAndSecondChildValueIsOne() {
        board.addMoveToBoard(0, playerNought);
        board.addMoveToBoard(1, playerNought);
        board.addMoveToBoard(2, playerCross);
        board.addMoveToBoard(3, playerNought);
        board.addMoveToBoard(4, playerCross);
        board.addMoveToBoard(5, playerCross);
        board.addMoveToBoard(7, playerCross);
        players.nextTurn();

        Node<NodeValue> boardTree = Tree.makeNode(board, rules, playerCross, players);
        int optimalScore = 1;
        assertEquals(optimalScore, Minimax.optimal(boardTree).score());
    }

    @Test
    public void treeWithLossAndDrawConditionReturnsTwoChildrenWithFirstALoss() {
        board.addMoveToBoard(0, playerCross);
        board.addMoveToBoard(1, playerCross);
        board.addMoveToBoard(2, playerNought);
        board.addMoveToBoard(3, playerNought);
        board.addMoveToBoard(4, playerCross);
        board.addMoveToBoard(6, playerCross);
        board.addMoveToBoard(7, playerNought);
        players.nextTurn();

        Node<NodeValue> boardTree = Tree.makeNode(board, rules, playerNought, players);
        assertEquals(-1, boardTree.getChild(0).getChild(0).getValue().score());
    }

    @Test
    public void treeWithLossAndDrawConditionReturnsTwoChildrenWithSecondADraw() {
        board.addMoveToBoard(0, playerCross);
        board.addMoveToBoard(1, playerCross);
        board.addMoveToBoard(2, playerNought);
        board.addMoveToBoard(3, playerNought);
        board.addMoveToBoard(4, playerCross);
        board.addMoveToBoard(6, playerCross);
        board.addMoveToBoard(7, playerNought);
        players.nextTurn();

        Node<NodeValue> boardTree = Tree.makeNode(board, rules, playerNought, players);
        assertEquals(0, boardTree.getChild(1).getChild(0).getValue().score());
    }

    @Test
    public void minimaxReturnsZeroOnTreeWithDrawOrLossCondition() {
        board.addMoveToBoard(0, playerCross);
        board.addMoveToBoard(1, playerCross);
        board.addMoveToBoard(2, playerNought);
        board.addMoveToBoard(3, playerNought);
        board.addMoveToBoard(4, playerCross);
        board.addMoveToBoard(6, playerCross);
        board.addMoveToBoard(7, playerNought);
        players.nextTurn();

        Node<NodeValue> boardTree = Tree.makeNode(board, rules, playerNought, players);
        int optimalScore = 0;
        assertEquals(optimalScore, Minimax.optimal(boardTree).score());
    }

    @Test
    public void emptyBoardReturnsNineChildren() {
        Node node = Tree.makeNode(board, rules, playerCross, players);
        assertEquals(9, node.size());
    }

    @Test
    public void TwoRowsFilledBoardReturnsThreeChildren() {
        board.addMoveToBoard(0, playerNought);
        board.addMoveToBoard(1, playerNought);
        board.addMoveToBoard(2, playerCross);
        board.addMoveToBoard(3, playerNought);
        board.addMoveToBoard(4, playerCross);
        board.addMoveToBoard(5, playerCross);

        Node<NodeValue> boardTree = Tree.makeNode(board, rules, playerCross, players);
        assertEquals(3, boardTree.size());
    }

    @Test
    public void TwoRowsFilledBoardReturnsThreeChildrenFirstChildIsLeaf() {
        board.addMoveToBoard(0, playerNought);
        board.addMoveToBoard(1, playerNought);
        board.addMoveToBoard(2, playerCross);
        board.addMoveToBoard(3, playerNought);
        board.addMoveToBoard(4, playerCross);
        board.addMoveToBoard(5, playerCross);

        Node<NodeValue> boardTree = Tree.makeNode(board, rules, playerCross, players);
        assertTrue(boardTree.getChild(0).isLeaf());
        assertEquals(1, boardTree.getChild(0).getValue().score());
    }

    @Test
    public void TwoRowsFilledBoardReturnsThreeChildrenMiddleChildHasTwoChildren() {
        board.addMoveToBoard(0, playerNought);
        board.addMoveToBoard(1, playerNought);
        board.addMoveToBoard(2, playerCross);
        board.addMoveToBoard(3, playerNought);
        board.addMoveToBoard(4, playerCross);
        board.addMoveToBoard(5, playerCross);

        Node<NodeValue> boardTree = Tree.makeNode(board, rules, playerCross, players);
        System.out.println(boardTree.getValue().score());
        assertEquals(2, boardTree.getChild(1).size());
    }

    @Test
    public void TwoRowsFilledBoardReturnsThreeChildrenMiddleChildHasTwoChildrenFirstIsLose() {
        board.addMoveToBoard(0, playerNought);
        board.addMoveToBoard(1, playerNought);
        board.addMoveToBoard(2, playerCross);
        board.addMoveToBoard(3, playerNought);
        board.addMoveToBoard(4, playerCross);
        board.addMoveToBoard(5, playerCross);

        Node<NodeValue> boardTree = Tree.makeNode(board, rules, playerCross, players);
        assertEquals(-1, boardTree.getChild(1).getChild(0).getValue().score());
        assertEquals(6, boardTree.getChild(1).getChild(0).getValue().position());
        assertTrue(boardTree.getChild(1).getChild(0).isLeaf());
    }

    @Test
    public void TwoRowsFilledBoardReturnsThreeChildrenMiddleChildHasTwoChildrenSecondIsZero() {
        board.addMoveToBoard(0, playerNought);
        board.addMoveToBoard(1, playerNought);
        board.addMoveToBoard(2, playerCross);
        board.addMoveToBoard(3, playerNought);
        board.addMoveToBoard(4, playerCross);
        board.addMoveToBoard(5, playerCross);

        Node<NodeValue> boardTree = Tree.makeNode(board, rules, playerCross, players);
        assertEquals(0, boardTree.getChild(1).getChild(1).getValue().score());
        assertEquals(8, boardTree.getChild(1).getChild(1).getValue().position());
        assertFalse(boardTree.getChild(1).getChild(1).isLeaf());
    }

    @Test
    public void TwoRowsFilledBoardReturnsThreeChildrenMiddleChildSecondChildIsWinLeafNode() {
        board.addMoveToBoard(0, playerNought);
        board.addMoveToBoard(1, playerNought);
        board.addMoveToBoard(2, playerCross);
        board.addMoveToBoard(3, playerNought);
        board.addMoveToBoard(4, playerCross);
        board.addMoveToBoard(5, playerCross);

        Node<NodeValue> boardTree = Tree.makeNode(board, rules, playerCross, players);
        assertEquals(1, boardTree.getChild(1).getChild(1).getChild(0).getValue().score());
        assertEquals(6, boardTree.getChild(1).getChild(1).getChild(0).getValue().position());
        assertTrue(boardTree.getChild(1).getChild(1).getChild(0).isLeaf());
    }

    @Test
    public void TwoRowsFilledBoardReturnsThreeChildrenLastChildIsLeaf() {
        board.addMoveToBoard(0, playerNought);
        board.addMoveToBoard(1, playerNought);
        board.addMoveToBoard(2, playerCross);
        board.addMoveToBoard(3, playerNought);
        board.addMoveToBoard(4, playerCross);
        board.addMoveToBoard(5, playerCross);

        Node<NodeValue> boardTree = Tree.makeNode(board, rules, playerCross, players);
        assertTrue(boardTree.getChild(2).isLeaf());
        assertEquals(1, boardTree.getChild(2).getValue().score());
    }
}