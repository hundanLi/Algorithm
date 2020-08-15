package problems.greedy;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-12 10:11
 * 思路：
 * 设dp[i]表示到达i的最小跳数
 **/
public class JumpII {
    public static int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int[] dp = new int[n];
        int i = 0;
        int reach = 1;
        while (i < n) {
            if (reach >= n) {
                return dp[n - 1];
            }
            int range = Math.min(n - 1, i + nums[i]);
            while (reach <= range) {
                dp[reach++] = 1 + dp[i];
            }
            i++;
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int jump = jump(nums);
        System.out.println(jump);

    }
}
