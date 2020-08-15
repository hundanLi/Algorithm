package problems.dynamic;


import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-19 00:41
 **/
public class CanPartition {
    public static boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if ((sum & 1) == 1) {
            return false;
        }
//        boolean dp = dp(nums, sum);
        Arrays.sort(nums);
        return dfs(nums, sum >> 1, nums.length - 1);
    }

    /** 经典dp
     * @param nums  数组
     * @param sum   目标和
     * @return  boolean
     *
     * 思路：
     *     设dp[i][j]表示num[0:i]有无子集的和为j，则分两种情况：
     *     （1）丢弃num[i]:dp[i][j] = dp[i-1][j];
     *     （2）纳入num[i]:dp[i][j] = j - num[i] > 0 && dp[i-1][j-num[i]]
     */
    private static boolean dp(int[] nums, int sum) {
        int n = nums.length;
        int half = sum >> 1;
        boolean[][] dp = new boolean[n][half + 1];
        //初始化左上角
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= half; j++) {
                dp[i][j] = dp[i - 1][j] || (j - nums[i] > 0 && dp[i - 1][j - nums[i]]);
            }
        }
        return dp[n - 1][half];
    }

    /** 深度优先搜索
     * @param num   数组
     * @param target    目标和
     * @param pos   数组索引
     * @return  boolean
     */
    private static boolean dfs(int[] num, int target, int pos) {
        if (target == 0) {
            return true;
        }
        if (target < 0 || pos < 0 || target < num[pos]) {
            return false;
        }

        int nextTarget = target - num[pos];
        if (dfs(num, nextTarget, pos - 1)) {
            return true;
        } else {
            return dfs(num, target, pos - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        boolean b = canPartition(nums);
        System.out.println(b);
    }
}
