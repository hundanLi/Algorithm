package problems.tree;

import explore.datastructure.tree.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-18 10:36
 **/
public class DistributeCoins {
    private int num;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return num;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        num += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }
}
