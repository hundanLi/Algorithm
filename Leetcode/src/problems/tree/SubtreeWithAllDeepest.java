package problems.tree;

import explore.datastructure.tree.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-16 12:37
 **/
public class SubtreeWithAllDeepest {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth == rightDepth) {
            return root;
        }
        if (leftDepth > rightDepth) {
            return subtreeWithAllDeepest(root.left);
        } else {
            return subtreeWithAllDeepest(root.right);
        }
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }

    public TreeNode subtreeWithAllDeepest2(TreeNode root) {
        return dfs(root).node;
    }

    private Result dfs(TreeNode root) {
        if (root == null) {
            return new Result(null, 0);
        }
        Result l = dfs(root.left);
        Result r = dfs(root.right);
        if (l.depth > r.depth) {
            l.depth++;
            return l;
        }
        if (l.depth < r.depth) {
            r.depth++;
            return r;
        }
        return new Result(root, l.depth + 1);
    }

    private static class Result {
        TreeNode node;
        int depth;

        Result(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}