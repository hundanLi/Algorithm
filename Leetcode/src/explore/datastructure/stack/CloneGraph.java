package explore.datastructure.stack;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-05 11:21
 **/
public class CloneGraph {
    private static class Node {
        public int val;
        List<Node> neighbors;

        public Node() {
        }

        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Node)) {
                return false;
            }

            Node node = (Node) o;

            if (val != node.val) return false;
            return neighbors.equals(node.neighbors);
        }

        @Override
        public int hashCode() {
            int result = val;
            result = 31 * result + neighbors.hashCode();
            return result;
        }
    }

    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    private Map<Node, Node> copy = new HashMap<>();

    private Node dfs(Node node) {
        if (copy.containsKey(node)) {
            return copy.get(node);
        }
        Node newNode = new Node();
        newNode.val = node.val;
        newNode.neighbors = new LinkedList<>();
        copy.put(node, newNode);
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(dfs(neighbor));
        }
        return newNode;
    }
}
