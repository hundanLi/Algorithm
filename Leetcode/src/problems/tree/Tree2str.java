package problems.tree;

import explore.datastructure.tree.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-14 23:00
 **/
public class Tree2str {
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.substring(1, sb.length() - 1);
    }

    private void preOrder(TreeNode root, StringBuilder sb) {
        sb.append("(").append(root.val);
        if (root.left == null && root.right != null) {
            sb.append("()");
        }
        if (root.left != null) {
            preOrder(root.left, sb);
        }
        if (root.right !=null) {
            preOrder(root.right, sb);
        }
        sb.append(")");
    }
}
