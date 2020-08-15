package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-16 22:52
 * 基本思路：
 *      设dp[i] 为将i拆成两个或以上数字得到的最大乘积，则
 *      dp[i] = max(dp[j] * dp[i-j]) for j <- 1 to i/2
 **/
public class IntegerBreak {
    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int i = integerBreak(10);
        System.out.println(i);
    }
}
