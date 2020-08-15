package problems.tree;

import explore.datastructure.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-20 13:11
 **/
public class MaxLevelSum {
    private int[] levelSum;
    public int maxLevelSum(TreeNode root) {
        int depth = getDepth(root);
        levelSum = new int[depth + 1];
        dfs(root, 1);
        int level = 1;
        int maxSum = levelSum[1];
        for (int i = 2; i <= depth; i++) {
            if (levelSum[i] > maxSum) {
                level = i;
                maxSum = levelSum[i];
            }
        }
        return level;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        levelSum[depth] += root.val;
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }

    private int getDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }
}
