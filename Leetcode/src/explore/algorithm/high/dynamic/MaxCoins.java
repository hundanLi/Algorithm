package explore.algorithm.high.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-03 14:01
 *
 * 设：dp[i][j]为戳爆i~j之间的气球所能获得硬币的最大数量（不包括下标为i、下标为j的气球）
 *   戳破i~j之间的气球可以看做先戳破i~m之间的气球和m~j之间的气球，最后戳破m。应该遍历m的所有位置，找到最大值。
 * 假设i<m<j
 * 有：dp[i][j]=Math.max(dp[i][j],dp[i][m]+dp[m][j]+nums[i]*nums[m]*nums[j]);
 *
 * 原文：https://blog.csdn.net/cc_fys/article/details/80774288
 **/
public class MaxCoins {
    public int maxCoins(int[] nums) {
        int[] coins = new int[nums.length + 2];
        //边界值为1
        coins[0] = 1;   
        coins[coins.length - 1] = 1;
        System.arraycopy(nums, 0, coins, 1, coins.length - 1 - 1);
        int[][] dp = new int[coins.length][coins.length];

        for (int interval = 2; interval < coins.length; interval++) {
            for (int i = 0; i + interval < coins.length; i++) {
                int j = i + interval;
                for (int m = i + 1; m < j; m++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][m] + dp[m][j] + coins[i] * coins[m] * coins[j]);
                }
            }
        }
        return dp[0][dp.length - 1];
    }

    class Solution {
        public int maxCoins(int[] nums) {
            int num[] = new int[nums.length+2];
            int res[][] = new int[num.length][num.length];
            num[0] = 1;
            num[nums.length+1] = 1;
            for(int i = 1; i < num.length-1; i++){
                num[i] = nums[i-1];
            }
            return dp(num, 0, num.length-1, res);
        }

        public int dp(int[] num, int left, int right, int[][] res){
            if(left == right - 1) return 0;
            if(res[left][right] > 0) return res[left][right];
            int max = 0;
            for(int i = left + 1; i < right; i++){
                max = Math.max(max, num[i] * num[left] * num[right] + dp(num, left, i, res) + dp(num, i, right, res));
            }
            res[left][right] = max;
            return max;
        }
    }
}
