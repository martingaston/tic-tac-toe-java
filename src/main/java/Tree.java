import java.util.List;

public class Tree {
    public static Node makeNode (Board board, Rules rules, Player maximisingPlayer, Players players) {

        Player currentPlayer = players.getCurrentPlayer();

        List<Integer> availableMoves = board.getAvailableIndexes();

        int moveIndex = availableMoves.get(0);
        board.addMoveToBoard(moveIndex, currentPlayer);

        if (maximisingPlayer == currentPlayer && rules.hasWinningMove(currentPlayer)) {
            return new Node(1);
        }

        if (maximisingPlayer != currentPlayer && rules.hasWinningMove(currentPlayer)) {
            return new Node(-1);
        }

        if (rules.gameIsOver()) {
            return new Node(0);
        }

        return new Node(0);
    }
}
