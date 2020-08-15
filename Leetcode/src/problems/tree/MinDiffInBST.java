package problems.tree;

import explore.datastructure.tree.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-16 00:08
 **/
public class MinDiffInBST {
    private int diff = Integer.MAX_VALUE;
    private int pre;
    private boolean flag = false;
    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        inOrder(root);
        return diff;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (flag) {
            diff = Math.min(diff, root.val - pre);
        } else {
            flag = true;
        }
        pre = root.val;
        inOrder(root.right);
    }
}
