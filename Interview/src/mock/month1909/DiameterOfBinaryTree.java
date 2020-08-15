package mock.month1909;

import datastructure.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-03 09:09
 **/
public class DiameterOfBinaryTree {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root, 0);
        return diameter;
    }

    private int getDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int left = depth;
        int right = depth;
        if (root.left != null) {
            left = getDepth(root.left, depth + 1);
        }
        if (root.right != null) {
            right = getDepth(root.right, depth + 1);
        }
        diameter = Math.max(diameter, left + right - 2 * depth);
        return Math.max(left, right);
    }

}
