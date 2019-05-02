import java.util.List;

public class Tree {
    public static Node<NodeValue> makeNode (Board board, Rules rules, Player maximisingPlayer, Players players) {
        Player currentPlayer = players.getCurrentPlayer();

        //TODO - Board state is MUTABLE so this will probably go really bad really fast - fix :)
        List<Integer> availableMoves = board.getAvailableIndexes();

        if (availableMoves.size() == 1) {
            int moveIndex = availableMoves.get(0);
            board.addMoveToBoard(moveIndex, currentPlayer);

            if (maximisingPlayer == currentPlayer && rules.hasWinningMove(currentPlayer)) {
                board.removeMoveFromBoard(moveIndex);
                return new Node<>(new NodeValue(1, moveIndex));
            }

            if (maximisingPlayer != currentPlayer && rules.hasWinningMove(currentPlayer)) {
                board.removeMoveFromBoard(moveIndex);
                return new Node<>(new NodeValue(-1, moveIndex));
            }

            if (rules.gameIsOver()) {
                board.removeMoveFromBoard(moveIndex);
                return new Node<>(new NodeValue(0, moveIndex));
            }
        }

        Node<NodeValue> root = new Node<>(new NodeValue(Integer.MIN_VALUE, Integer.MIN_VALUE));

        for ( int move : availableMoves) {
            currentPlayer = players.getCurrentPlayer();

            board.addMoveToBoard(move, currentPlayer);

            if (maximisingPlayer == currentPlayer && rules.hasWinningMove(currentPlayer)) {
                root.addChild(new Node<>(new NodeValue(1, move)));
            } else if (maximisingPlayer != currentPlayer && rules.hasWinningMove(currentPlayer)) {
                root.addChild(new Node<>(new NodeValue(-1, move)));
            } else {
                Node<NodeValue> nextChildNode;
                if (maximisingPlayer == currentPlayer) {
                    nextChildNode = new Node<>(new NodeValue(Integer.MIN_VALUE, move));
                } else {
                    nextChildNode = new Node<>(new NodeValue(Integer.MAX_VALUE, move));
                }
                players.nextTurn();
                makeNewChildNode(board, nextChildNode, rules, maximisingPlayer, players);
                root.addChild(nextChildNode);
                resetPlayer(maximisingPlayer, players);
            }

            board.removeMoveFromBoard(move);
        }
        return root;
    }

    private static void makeNewChildNode(Board board, Node<NodeValue> node, Rules rules,
                                                    Player maximisingPlayer, Players players) {
        List<Integer> availableMoves = board.getAvailableIndexes();
        for ( int move : availableMoves) {
            Player currentPlayer = players.getCurrentPlayer();

            board.addMoveToBoard(move, currentPlayer);

            if (maximisingPlayer == currentPlayer && rules.hasWinningMove(currentPlayer)) {
                node.addChild(new Node<>(new NodeValue(1, move)));
            } else if (maximisingPlayer != currentPlayer && rules.hasWinningMove(currentPlayer)) {
                node.addChild(new Node<>(new NodeValue(-1, move)));
            } else if (rules.gameIsOver()) {
                node.addChild(new Node<>(new NodeValue(0, move)));
            } else {
                Node<NodeValue> nextChildNode;
                if (maximisingPlayer == currentPlayer) {
                    nextChildNode = new Node<>(new NodeValue(Integer.MIN_VALUE, move));
                } else {
                    nextChildNode = new Node<>(new NodeValue(Integer.MAX_VALUE, move));
                }
                players.nextTurn();
                makeNewChildNode(board, nextChildNode, rules, maximisingPlayer, players);
                node.addChild(nextChildNode);
                resetPlayer(maximisingPlayer, players);
            }

            board.removeMoveFromBoard(move);
        }
    }

    private static void resetPlayer(Player maximisingPlayer, Players players) {
        if (players.getCurrentPlayer() != maximisingPlayer) {
            players.nextTurn();
        }
    }
}
