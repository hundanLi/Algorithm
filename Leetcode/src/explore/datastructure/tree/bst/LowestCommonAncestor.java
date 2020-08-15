package explore.datastructure.tree.bst;

import explore.datastructure.tree.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-20 10:36
 **/
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p, q);
    }

    private TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = find(root.left, p, q);
        TreeNode right = find(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        }
        return left;
    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            int min = Math.min(p.val, q.val);
            int max = Math.max(p.val, q.val);
            TreeNode node = root;
            while (true) {
                if (node.val >= min && node.val <= max) {
                    return node;
                }
                if (node.val > max) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
        }
    }
}
