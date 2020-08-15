package problems.tree;

import explore.datastructure.tree.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-14 16:30
 **/
public class ConvertBST {
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        reversePreOrder(root);
        return root;
    }

    private void reversePreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        reversePreOrder(root.right);
        sum += root.val;
        root.val = sum;
        reversePreOrder(root.left);
    }
}
