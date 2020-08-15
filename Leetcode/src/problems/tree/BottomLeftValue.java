package problems.tree;

import explore.datastructure.tree.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-14 15:51
 **/
public class BottomLeftValue {
    private int maxDepth = 0;
    private int ans;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        depth++;
        if (root.left == null && root.right == null) {
            if (maxDepth < depth) {
                maxDepth = depth;
                ans = root.val;
            }
        } else {
            dfs(root.left, depth);
            dfs(root.right, depth);
        }

    }
}
