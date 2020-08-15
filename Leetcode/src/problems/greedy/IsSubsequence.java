package problems.greedy;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-14 09:29
 **/
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (t == null || t.length() == 0) {
            return s == null || s.length() == 0;
        }
        if (s == null || s.length() == 0) {
            return true;
        }

        int m = s.length();
        int n = t.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        //初始化第一行
        for (int i = 0; i <= n; i++) {
            dp[0][i] = true;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                dp[i][j] = dp[i][j] || dp[i][j - 1];
            }
        }
        return dp[m][n];
    }

    class Solution {
        public boolean isSubsequence(String s, String t) {
            if (t == null) {
                return s == null;
            }
            int si;
            int ti = 0;
            for (si = 0; si < s.length(); si++) {
                ti = t.indexOf(s.charAt(si), ti);
                if (ti == -1) {
                    return false;
                }
                ti++;
            }
            return true;
        }

    }

}
