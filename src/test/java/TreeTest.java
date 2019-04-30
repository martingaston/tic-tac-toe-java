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
}