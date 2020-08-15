package problems.tree;

import explore.datastructure.tree.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-14 11:07
 **/
public class PathSum3 {
    private int ans;
    public int pathSum(TreeNode root, int sum) {
        preOrder(root, sum);
        return ans;
    }

    private void preOrder(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        dfs(root, target, 0);
        preOrder(root.left, target);
        preOrder(root.right, target);
    }

    private void dfs(TreeNode root, int target, int sum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        if (sum == target) {
            ans++;
        }
        dfs(root.left, target, sum);
        dfs(root.right, target, sum);
    }
}
