package explore.datastructure.tree.binarytree;

import explore.datastructure.tree.TreeNode;

import java.util.Stack;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-17 09:31
 **/
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }


    public boolean isMirror(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{root.left, root.right});
        TreeNode[] treeNodes;
        TreeNode l, r;
        while (!stack.isEmpty()) {
            treeNodes = stack.pop();
            l = treeNodes[0];
            r = treeNodes[1];
            if (l == null && r == null) {
                continue;
            }
            if (l == null || r == null) {
                return false;
            }
            if (l.val != r.val) {
                return false;
            }
            stack.push(new TreeNode[]{l.left, r.right});
            stack.push(new TreeNode[]{l.right, r.left});
        }
        return true;
    }
}
