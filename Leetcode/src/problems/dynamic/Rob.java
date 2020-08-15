package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-15 11:20
 **/
public class Rob {
    public int rob(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int n = num.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = num[0];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], num[i - 1] + dp[i - 2]);
        }
        return dp[n];
    }
}
