package problems.tree;

import explore.datastructure.tree.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-14 10:47
 **/
public class SumOfLeftLeaves {
    private int sum;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return sum;
        }
        dfs(root.left, true);
        dfs(root.right, false);
        return sum;
    }

    private void dfs(TreeNode root, boolean isLeft) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && isLeft) {
            sum += root.val;
            return;
        }
        dfs(root.left, true);
        dfs(root.right, false);
    }
}
