package problems.tree;

import explore.datastructure.tree.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-18 14:07
 **/
public class InsertIntoMaxTree {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        } else {
            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }
    }
}
