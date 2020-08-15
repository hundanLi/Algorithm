package problems.tree;

import explore.datastructure.tree.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-15 14:28
 **/
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) {
            return null;
        }
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int s, int e) {
        if (s > e) {
            return null;
        }
        int i = s;
        int max = nums[i];
        for (int j = i + 1; j <= e; j++) {
            if (max < nums[j]) {
                i = j;
                max = nums[j];
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = construct(nums, s, i - 1);
        root.right = construct(nums, i + 1, e);
        return root;
    }
}
