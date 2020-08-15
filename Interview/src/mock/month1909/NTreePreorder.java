package mock.month1909;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-24 15:48
 **/
public class NTreePreorder {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    private List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        for (Node ch : root.children) {
            preorder(ch);
        }
        return list;
    }

}
