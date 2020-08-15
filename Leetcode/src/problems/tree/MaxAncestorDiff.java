package problems.tree;

import explore.datastructure.tree.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-18 15:20
 **/
public class MaxAncestorDiff {
    private int maxdiff;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        minMax(root, -1);
        return maxdiff;
    }

    private int[] minMax(TreeNode root, int pVal) {
        if (root == null) {
            return new int[]{pVal, pVal};
        }
        int[] left = minMax(root.left, root.val);
        int[] right = minMax(root.right, root.val);
        int[] res = new int[2];
        res[0] = Math.min(left[0], right[0]);
        res[1] = Math.max(left[1], right[1]);
        maxdiff = Math.max(maxdiff, Math.max(Math.abs(root.val - res[0]), Math.abs(root.val - res[1])));
        res[0] = Math.min(res[0], root.val);
        res[1] = Math.max(res[1], root.val);
        return res;
    }

    static class Solution {
        private int maxDiff;

        public int maxAncestorDiff(TreeNode root) {
            if (root == null) {
                return 0;
            }
            dfs(root, root.val, root.val);
            return maxDiff;
        }

        private void dfs(TreeNode root, int min, int max) {
            if (root == null) {
                return;
            }
            min = Math.min(min, root.val);
            max = Math.max(max, root.val);
            if (root.left == null && root.right == null) {
                maxDiff = Math.max(maxDiff, max - min);
            } else {
                dfs(root.left, min, max);
                dfs(root.right, min, max);
            }
        }
    }
}
