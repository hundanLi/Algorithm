package problems.tree;

import explore.datastructure.tree.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-15 18:52
 **/
public class TrimBST {
    public TreeNode trimBST(TreeNode root, int l, int r) {
        if (root == null) {
            return null;
        }
        if (root.val < l) {
            return trimBST(root.right, l, r);
        }
        if (root.val > r) {
            return trimBST(root.left, l, r);
        }
        root.left = trimBST(root.left, l, r);
        root.right = trimBST(root.right, l, r);
        return root;
    }
}
