package problems.tree;

import explore.datastructure.tree.TreeNode;


/**
 * @author li
 * @version 1.0
 * @date 2019-11-10 10:49
 **/
public class Rob3 {

    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    /** res[0]为不包括根节点的最大值，res[1]为包括根节点的最大值 */
    private int[] dfs(TreeNode root) {
        int[] res = new int[2];
        if (root == null) {
            return res;
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        // 不包含根节点，最大值为两个子树的最大值之和
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 包含根节点
        res[1] = left[0] + right[0] + root.val;
        return res;
    }
}
