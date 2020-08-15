package explore.datastructure.tree.narytree;

import explore.datastructure.tree.Node;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-21 12:20
 **/
public class MaxDepth {

    int ans = 1;

    public int maxDepth(Node root) {
        return depth(root);
    }

    private int depth(Node root) {
        if (root == null) {
            return 0;
        }
        int depth;
        int max = 0;
        for (Node node : root.children) {
            depth = depth(node);
            max = Math.max(max, depth);
        }
        return max + 1;
    }
}
