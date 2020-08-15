package problems.tree;

import explore.datastructure.tree.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-19 13:54
 **/
public class BtreeGameWinningMove {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode xNode = search(root, x);
        int leftCount = count(xNode.left);
        int rightCount = count(xNode.right);
        int count = 1 + leftCount + rightCount;
        int half = (n >> 1);
        return leftCount > half || rightCount > half || count <= half;
    }

    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }

    private TreeNode search(TreeNode root, int x) {
        if (root == null) {
            return null;
        }
        if (root.val == x) {
            return root;
        }
        TreeNode left = search(root.left, x);
        if (left != null) {
            return left;
        }
        return search(root.right, x);
    }

}
