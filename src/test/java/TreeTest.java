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

        Node node = Tree.makeNode(board, rules, playerCross, players);
        assertEquals(0, node.getValue());
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

        Node node = Tree.makeNode(board, rules, playerCross, players);
        assertEquals(1, node.getValue());
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

        Node node = Tree.makeNode(board, rules, playerNought, players);
        assertEquals(-1, node.getValue());
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

        Node node = Tree.makeNode(board, rules, playerCross, players);
        int loss = -1;
        assertEquals(loss, node.getChild(0).getValue());
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

        Node node = Tree.makeNode(board, rules, playerCross, players);
        assertEquals(win, node.getChild(1).getChild(0).getValue());
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

        Node<Integer> boardTree = Tree.makeNode(board, rules, playerCross, players);
        int optimalScore = 1;
        assertEquals(optimalScore, Minimax.optimal(boardTree));
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

        Node boardTree = Tree.makeNode(board, rules, playerNought, players);
        assertEquals(-1, boardTree.getChild(0).getChild(0).getValue());
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

        Node boardTree = Tree.makeNode(board, rules, playerNought, players);
        assertEquals(0, boardTree.getChild(1).getChild(0).getValue());
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

        Node<Integer> boardTree = Tree.makeNode(board, rules, playerNought, players);
        int optimalScore = 0;
        assertEquals(optimalScore, Minimax.optimal(boardTree));
    }

    @Test
    public void emptyBoardReturnsNineChildren() {
        Node node = Tree.makeNode(board, rules, playerCross, players);
        assertEquals(9, node.size());
    }
}