package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-30 13:51
 **/
public class MoneyAmount {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int min = Integer.MAX_VALUE;
                for (int pivot = start + (len - 1) / 2; pivot < start + len - 1; pivot++) {
                    int res = pivot + Math.max(dp[start][pivot - 1], dp[pivot + 1][start + len - 1]);
                    min = min < res ? min : res;
                }
                dp[start][start + len - 1] = min;
            }
        }
        return dp[1][n];
    }
}
