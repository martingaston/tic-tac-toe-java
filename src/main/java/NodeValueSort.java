import java.util.Comparator;

public class NodeValueSort implements Comparator<NodeValue>
{
    @Override
    public int compare(NodeValue a, NodeValue b)
    {
        return a.score() - b.score();
    }
} 