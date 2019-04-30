import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    private T value;
    private List<Node<T>> children = new ArrayList<>();

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public boolean isLeaf() {
        return this.children.size() == 0;
    }

    public int size() {
        return this.children.size();
    }

    public Node<T> getChild(int index) {
        return this.children.get(index);
    }

    public void addChild(Node<T> child) {
        this.children.add(child);
    }
}
