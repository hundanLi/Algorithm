package mock.month1909;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-02 09:18
 **/
public class KInversePairs {
    public int kInversePairs(int n, int k) {
        if (k == 0) {
            return 1;
        }
        long[][] dp = new long[n + 1][k + 1];
        int mod = 1000000007;
        dp[1][1] = 0;
        dp[1][0] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < k + 1; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                if (j >= i) {
                    dp[i][j] -= dp[i - 1][j - i];
                }
                // dp[i][j]可能 < 0
                dp[i][j] = (dp[i][j] + mod) % mod;
            }
        }
        return (int) dp[n][k];
    }
}
