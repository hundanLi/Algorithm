package explore.algorithm.high.treegragh;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-23 19:21
 **/
public class MaxPathSum {
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        inorder(root, maxSum);
        return maxSum[0];
    }

    private int inorder(TreeNode root, int[] maxSum) {
        if (root == null) {
            return 0;
        }
        int leftSum = inorder(root.left, maxSum);
        //左子树 -> 当前结点 的和
        int left2now = leftSum > 0 ? root.val + leftSum : root.val;

        int rightSum = inorder(root.right, maxSum);
        //右子树 -> 当前结点 的和
        int right2now = rightSum > 0 ? root.val + rightSum : root.val;

        //左子树 -> 右子树 的和
        int left2right = leftSum + root.val + rightSum;

        if (left2now > right2now) {
            //左子树 -> 当前结点 的和最大
            return updateMax(maxSum, left2now, left2right);
        } else {
            return updateMax(maxSum, right2now, left2right);
        }
    }

    private int updateMax(int[] maxSum, int side, int left2right) {
        if (side > left2right) {
            maxSum[0] = Math.max(maxSum[0], side);
        } else {
            //左 -> 右的和最大
            maxSum[0] = Math.max(maxSum[0], left2right);
        }
        return side;
    }

    class Solution {
        //牛逼解法

        private int ret = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {

            getMax(root);
            return ret;
        }
        /**
         对于任意一个节点, 如果最大和路径包含该节点, 那么只可能是两种情况:
         1. 其左右子树中所构成的和路径值较大的那个加上该节点的值后向父节点回溯构成最大路径
         2. 左右子树都在最大路径中, 加上该节点的值构成了最终的最大路径
         **/
        private int getMax(TreeNode r) {
            if(r == null) {
                return 0;
            }
            // 如果子树路径和为负则应当置0表示最大路径不包含子树
            int left = Math.max(0, getMax(r.left));
            int right = Math.max(0, getMax(r.right));
            // 判断在该节点包含左右子树的路径和是否大于当前最大路径和
            ret = Math.max(ret, r.val + left + right);
            return Math.max(left, right) + r.val;
        }
    }
}
