package explore.algorithm.junior.tree;


/**
 * @author li
 * @version 1.0
 * @date 2019-02-18 00:23
 **/
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        depth++;
        int left = dfs(root.left, depth);
        int right =  dfs(root.right, depth);
        return left > right ? left : right;
    }
}
