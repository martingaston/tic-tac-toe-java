import java.util.List;

public class Tree {
    public static Node<Integer> makeNode (Board board, Rules rules, Player maximisingPlayer, Players players) {

        Player currentPlayer = players.getCurrentPlayer();

        //TODO - Board state is MUTABLE so this will probably go really bad really fast - fix :)
        List<Integer> availableMoves = board.getAvailableIndexes();

        if (availableMoves.size() == 1) {
            int moveIndex = availableMoves.get(0);
            board.addMoveToBoard(moveIndex, currentPlayer);

            if (maximisingPlayer == currentPlayer && rules.hasWinningMove(currentPlayer)) {
                return new Node<>(1);
            }

            if (maximisingPlayer != currentPlayer && rules.hasWinningMove(currentPlayer)) {
                return new Node<>(-1);
            }

            if (rules.gameIsOver()) {
                return new Node<>(0);
            }
        }

        Node<Integer> currentMoveOutcomes = new Node<>(0);

        for ( int move : availableMoves) {
            currentPlayer = players.getCurrentPlayer();
            board.addMoveToBoard(move, currentPlayer);

            if (maximisingPlayer == currentPlayer && rules.hasWinningMove(currentPlayer)) {
                currentMoveOutcomes.addChild(new Node<>(1));
            } else if (maximisingPlayer != currentPlayer && rules.hasWinningMove(currentPlayer)) {
                currentMoveOutcomes.addChild(new Node<>(-1));
            } else {
                Node<Integer> nextChildNode = new Node<>(0);
                players.nextTurn();
                nextChildNode.addChild(makeNode(board, rules, maximisingPlayer, players));
                currentMoveOutcomes.addChild(nextChildNode);
                resetPlayer(maximisingPlayer, players);
            }

            board.removeMoveFromBoard(move);
        }

        return currentMoveOutcomes;
    }

    private static void resetPlayer(Player maximisingPlayer, Players players) {
        if (players.getCurrentPlayer() != maximisingPlayer) {
            players.nextTurn();
        }
    }
}
