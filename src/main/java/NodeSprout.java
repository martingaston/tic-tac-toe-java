import java.util.ArrayList;
import java.util.List;

public class NodeSprout<T> {
    private T value;
    private List<NodeSprout<T>> children = new ArrayList<>();

    public NodeSprout(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public boolean isLeaf() {
        return this.children.size() == 0;
    }

    public NodeSprout getChild(int index) {
        return this.children.get(index);
    }

    public void addChild(NodeSprout<T> child) {
        this.children.add(child);
    }
}
