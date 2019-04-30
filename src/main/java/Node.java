public class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this(value, null, null);
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    public Node getLeftNode() {
        return left;
    }

    public Node getRightNode() {
        return right;
    }
}
