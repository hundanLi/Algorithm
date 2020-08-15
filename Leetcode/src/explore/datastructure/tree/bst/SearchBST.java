package explore.datastructure.tree.bst;

import explore.datastructure.tree.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-17 15:42
 **/
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
