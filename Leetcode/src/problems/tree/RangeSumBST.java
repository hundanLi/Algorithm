package problems.tree;

import explore.datastructure.tree.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-16 15:59
 **/
public class RangeSumBST {
    public int rangeSumBST(TreeNode root, int l, int r) {
        if (root == null) {
            return 0;
        }
        if (root.val >= l && root.val <= r) {
            return root.val + rangeSumBST(root.left, l, r) + rangeSumBST(root.right, l, r);
        } else if (root.val < l) {
            return rangeSumBST(root.right, l, r);
        } else {
            return rangeSumBST(root.left, l, r);
        }
    }
}
