package explore.datastructure.tree.binarytree;

import explore.datastructure.tree.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-16 10:08
 **/
public class MaxDepth {

    private int ans = 0;

    public int maxDepth(TreeNode root) {
//        return bottomUp(root);
        topDown(root, 1);
        return ans;
    }

    private int bottomUp(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    private void topDown(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            ans = Math.max(ans, depth);
            return;
        }
        topDown(root.left, depth + 1);
        topDown(root.right, depth + 1);
    }

}

