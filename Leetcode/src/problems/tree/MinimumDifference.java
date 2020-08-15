package problems.tree;

import explore.datastructure.tree.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-14 16:15
 **/
public class MinimumDifference {
    private int minDiff = Integer.MAX_VALUE;
    private int pre = -1;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        inOrder(root);
        return minDiff;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (pre >= 0) {
            minDiff = Math.min(minDiff, root.val - pre);
        }
        pre = root.val;
        inOrder(root.right);
    }
}
