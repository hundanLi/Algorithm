package leetcodecup.spring2020;

import explore.datastructure.tree.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-18 17:14
 **/
public class MinimalExecTime {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public double minimalExecTime(TreeNode root) {
        int[] ans = dfs(root);
        int need = ans[0] + ans[1];
        return need / 2.0;
    }

    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        int[] ans = new int[2];

        if (l[0] > r[0]) {
            int[] tmp = l;
            l = r;
            r = tmp;
        }

        ans[1] += l[0];
        r[0] -= l[0];
        int merge = Math.min(l[1] * 2, r[0]);
        l[1] -= merge / 2;
        r[0] -= merge;
        ans[1] += merge;
        ans[1] += r[1] + l[1];
        ans[0] += r[0];
        ans[0] += 2 * root.val;

        return ans;
    }
}
