package explore.datastructure.tree;

import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-21 12:03
 **/
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
