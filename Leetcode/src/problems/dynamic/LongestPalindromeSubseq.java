package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-21 23:26
 **/
public class LongestPalindromeSubseq {


    /**
     * 思路：
     *  设dp[i][j]表示s[i:j]中的最长回文子序列长度，则
     *  (1) s[i] == s[j] ==> dp[i][j] = dp[i+1][j-1] + 2;
     *  (2) s[i] != s[j] ==> dp[i][j] = max(dp[i+1][j], dp[i][j-1])
     *  初始化: dp[i][i] = 1
     *  return dp[0][n-1]
     */
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }


    /**
     * 优化空间为O(n)
     */
    public int longestPalindromeSubseqOptimizeSpace(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] pre = new int[n];
        int[] cur = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            cur[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    cur[j] = pre[j - 1] + 2;
                } else {
                    cur[j] = Math.max(pre[j], cur[j - 1]);
                }
            }
            int[] temp = pre;
            pre = cur;
            cur = temp;
        }
        return pre[n - 1];
    }

}
