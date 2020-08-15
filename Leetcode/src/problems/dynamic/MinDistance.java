package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-10 19:19
 * 思路：假设dp[i][j]表示word1[0:i-1] 转化成 word2[0:j-1]需要的最少步骤，i,j >= 1 ,则
 *      1.若word1[i - 1] == word2[j - 1]：dp[i][j] = dp[i-1][j-1]
 *      2.若word1[i - 1] != word2[j - 1]：
 *          (1)替换：dp[i][j] = dp[i-1][j-1] + 1
 *          (2)增加：dp[i][j] = dp[i][j-1] + 1
 *          (3)删除：dp[i][j] = dp[i-1][j] + 1
 *        即 dp[i][j] = min(dp[i-1][j-1], dp[i][j-1], dp[i-1][j]) + 1
 *      细节：
 *      初始化：
 *          dp[0][j] = j
 *          dp[i][0] = i
 **/
public class MinDistance {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) {
            return word2.length();
        }
        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }
        int m = word1.length() + 1;
        int n = word2.length() + 1;
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
