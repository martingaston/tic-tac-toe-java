import java.util.List;

public class Tree {
    public static Node<Integer> makeNode (Board board, Rules rules, Player maximisingPlayer, Players players) {

        Player currentPlayer = players.getCurrentPlayer();

        //TODO - Board state is MUTABLE so this will probably go really bad really fast - fix :)
        List<Integer> availableMoves = board.getAvailableIndexes();

        if (availableMoves.size() == 1) {
            int moveIndex = availableMoves.get(0);
            System.out.println("Adding leaf node " + moveIndex);

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

        for ( int moveIndex : availableMoves) {
            currentPlayer = players.getCurrentPlayer();
            System.out.println("current player: " + currentPlayer.getSymbol());

            System.out.println("Adding moveIndex" + moveIndex);
            board.addMoveToBoard(moveIndex, currentPlayer);

            if (maximisingPlayer == currentPlayer && rules.hasWinningMove(currentPlayer)) {
                currentMoveOutcomes.addChild(new Node<>(1));
            } else if (maximisingPlayer != currentPlayer && rules.hasWinningMove(currentPlayer)) {
                currentMoveOutcomes.addChild(new Node<>(-1));
            } else {
                System.out.println("New branch");
                Node<Integer> nextChildNode = new Node<>(0);
                players.nextTurn();
                nextChildNode.addChild(makeNode(board, rules, maximisingPlayer, players));
                currentMoveOutcomes.addChild(nextChildNode);
            }

            board.removeMoveFromBoard(moveIndex);
        }

        currentMoveOutcomes.print();

        return currentMoveOutcomes;
    }
}
