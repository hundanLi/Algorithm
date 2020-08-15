package problems.tree;

import explore.datastructure.tree.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-22 13:19
 **/
public class SumNumbers {
    private int sum;
    public int sumNumbers(TreeNode root) {
        if (root != null) {
            dfs(root, 0);
        }
        return sum;
    }

    private void dfs(TreeNode root, int num) {
        if (root.left == null && root.right == null) {
            num = num * 10 + root.val;
            sum += num;
            return;
        }
        num = num * 10 + root.val;
        if (root.left != null) {
            dfs(root.left, num);
        }
        if (root.right != null) {
            dfs(root.right, num);
        }
    }
}
