public class Minimax {
    public static int optimal(Node root) {
        return optimal(root, "maximiser");
    }

    private static int optimal(Node root, String currentPlayer) {
        if (root.isLeaf()) {
            return root.getValue();
        }

        if (currentPlayer.equals("maximiser")) {
            return Math.max(
                    optimal(root.getLeftNode(), switchPlayer(currentPlayer)),
                    optimal(root.getRightNode(), switchPlayer(currentPlayer))
            );
        } else {
            return Math.min(
                    optimal(root.getLeftNode(), switchPlayer(currentPlayer)),
                    optimal(root.getRightNode(), switchPlayer(currentPlayer))
            );
        }
    }

    private static String switchPlayer(String currentPlayer) {
        return currentPlayer.equals("maximiser") ? "minimiser" : "maximiser";
    }
}
