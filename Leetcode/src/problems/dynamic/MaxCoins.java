package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-16 18:56
 * 思路：
 * 设：dp[i][j]为戳爆i~j之间的气球所能获得硬币的最大数量（不包括下标为i、下标为j的气球）
 * 戳破i~j之间的气球可以看做先戳破i~m之间的气球和m~j之间的气球，最后戳破m。应该遍历m的所有位置，找到最大值。
 * 假设i<m<j
 * 有：dp[i][j]=Math.max(dp[i][j],dp[i][m]+dp[m][j]+nums[i]*nums[m]*nums[j]);
 **/
public class MaxCoins {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] coins = new int[nums.length + 2];
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        coins[0] = 1;
        coins[coins.length - 1] = 1;
        System.arraycopy(nums, 0, coins, 1, coins.length - 2);

        for (int k = 2; k < coins.length; k++) {
            for (int i = 0; i + k < coins.length; i++) {
                int j = i + k;
                for (int m = i + 1; m < j; m++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][m] + dp[m][j] + coins[m] * coins[i] * coins[j]);
                }
            }
        }
        return dp[0][nums.length + 1];
    }
}
