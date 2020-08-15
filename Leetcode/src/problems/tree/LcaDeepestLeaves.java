package problems.tree;

import explore.datastructure.tree.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-19 11:00
 **/
public class LcaDeepestLeaves {
    private TreeNode node;
    private int maxDepth;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root, 0);
        return node;
    }

    private int dfs(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        depth++;
        // 计算左右子树的深度
        int left = dfs(root.left, depth), right = dfs(root.right, depth);
        depth = Math.max(left, right);
        if (left == right && depth >= maxDepth) {
            node = root;
            maxDepth = depth;
        }
        return depth;
    }
}
