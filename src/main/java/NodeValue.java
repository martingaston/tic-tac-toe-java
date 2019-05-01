import java.util.AbstractMap;
import java.util.Map;

public class NodeValue {
    private Map.Entry<Integer, Integer> nodeValue;

    public NodeValue(Integer score, Integer position) {
        nodeValue = new AbstractMap.SimpleImmutableEntry<>(score, position);
    }

    public int score() {
        return nodeValue.getKey();
    }

    public int position() {
        return nodeValue.getValue();
    }
}
