import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Minimax {
    public static int optimal(Node<Integer> root) {
        return optimal(root, "maximiser");
    }

    private static int optimal(Node<Integer> root, String currentPlayer) {
        if (root.isLeaf()) {
            return root.getValue();
        }

        List<Integer> optimalChildren = loopChildren(root, currentPlayer);

        if (currentPlayer.equals("maximiser")) {
            return Collections.max(optimalChildren);
        } else {
            return Collections.min(optimalChildren);
        }
    }

    private static List<Integer> loopChildren(Node<Integer> root, String currentPlayer) {
        List<Integer> optimalChildren = new ArrayList<>();
        for (int i = 0; i < root.size(); i++) {
            int nextOptimal = optimal(root.getChild(i), switchPlayer(currentPlayer));
            optimalChildren.add(nextOptimal);
        }
        return optimalChildren;
    }

    private static String switchPlayer(String currentPlayer) {
        return currentPlayer.equals("maximiser") ? "minimiser" : "maximiser";
    }
}
