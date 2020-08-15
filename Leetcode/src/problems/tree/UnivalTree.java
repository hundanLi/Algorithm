package problems.tree;

import explore.datastructure.tree.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-17 14:41
 **/
public class UnivalTree {
    private int val;
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        val = root.val;
        return dfs(root);
    }

    private boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.val != val) {
            return false;
        }
        return dfs(root.left) && dfs(root.right);
    }
}
