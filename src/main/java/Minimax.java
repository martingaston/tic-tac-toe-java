import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Minimax {
    public static NodeValue optimal(Node<NodeValue> root) {
        return optimal(root, "maximiser");
    }

    private static NodeValue optimal(Node<NodeValue> root, String currentPlayer) {
        if (root.isLeaf()) {
            return root.getValue();
        }

        List<NodeValue> optimalChildren = loopChildren(root, currentPlayer);

        if (currentPlayer.equals("maximiser")) {
            return Collections.max(optimalChildren, new NodeValueSort());
        } else {
            return Collections.min(optimalChildren, new NodeValueSort());
        }
    }

    private static List<NodeValue> loopChildren(Node<NodeValue> root, String currentPlayer) {
        List<NodeValue> optimalChildren = new ArrayList<>();
        for (int i = 0; i < root.size(); i++) {
            NodeValue nextOptimal = optimal(root.getChild(i), switchPlayer(currentPlayer));
            optimalChildren.add(nextOptimal);
        }
        return optimalChildren;
    }

    private static String switchPlayer(String currentPlayer) {
        return currentPlayer.equals("maximiser") ? "minimiser" : "maximiser";
    }
}
