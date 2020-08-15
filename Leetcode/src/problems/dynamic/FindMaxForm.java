package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-21 20:11
 **/
public class FindMaxForm {
    /**
     * 设dp[i][j]表示i个0和j个1可以最多构造多少个字符串，
     * 则对于数组中每个字符串（含zeros个0,ones个1），当我们选择构造它时，剩下的0,1还能构造多少个字符串？
     * dp[i][j] = max(dp[i][j], 1 + dp[i-zeros][j-ones])
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int zeros = 0;
            int ones = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }

            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    int zeroLeft = i - zeros;
                    int oneLeft = j - ones;
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[zeroLeft][oneLeft]);
                }
            }
        }
        return dp[m][n];
    }
}
