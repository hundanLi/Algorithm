package mock.month1909;


import datastructure.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-02 09:06
 **/
public class PruneTree {
    public TreeNode pruneTree(TreeNode root) {
        return removeChild(root);
    }

    private TreeNode removeChild(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = removeChild(root.left);
        root.right = removeChild(root.right);
        if (root.left == null && root.right == null) {
            return root.val == 0 ? null : root;
        }
        return root;
    }
}
