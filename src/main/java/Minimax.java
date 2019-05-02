import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Minimax {
    public static NodeValue optimal(Node<NodeValue> root) {
        return optimal(root, "maximiser", 9);
    }

    private static NodeValue optimal(Node<NodeValue> root, String currentPlayer, int depth) {
        if (root.isLeaf()) {
            NodeValue leaf = root.getValue();
            int depthAdjustedScore = leaf.score() * depth;
            return new NodeValue(depthAdjustedScore, leaf.position());
        }

        List<NodeValue> optimalChildren = new ArrayList<>();
        for (int i = 0; i < root.size(); i++) {
            NodeValue nextOptimal = optimal(root.getChild(i), switchPlayer(currentPlayer), depth - 1);
            optimalChildren.add(nextOptimal);
        }

        if (currentPlayer.equals("maximiser")) {
            NodeValue max = Collections.max(optimalChildren, new NodeValueSort());
            return new NodeValue(max.score(), max.position());
        } else {
            NodeValue min = Collections.min(optimalChildren, new NodeValueSort());
            return new NodeValue(min.score(), min.position());
        }
    }

    private static String switchPlayer(String currentPlayer) {
        return currentPlayer.equals("maximiser") ? "minimiser" : "maximiser";
    }
}
