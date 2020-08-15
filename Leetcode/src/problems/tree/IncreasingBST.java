package problems.tree;

import explore.datastructure.tree.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-16 15:42
 **/
public class IncreasingBST {
    private TreeNode nRoot = new TreeNode(0);
    private TreeNode node = nRoot;

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        increasingBST(root.left);
        root.left = null;
        node.right = root;
        node = node.right;
        increasingBST(root.right);
        return nRoot.right;
    }
}
