package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-18 00:35
 **/
public class IsSubsequence {

    /**
     * 设dp[i][j]表示s[0:j-1]是否为t[0:j-1]的子串，则
     * if s[i-1] == t[j-1] then dp[i][j] = dp[i-1][j-1]
     * (丢弃t[j-1]) dp[i][j] = dp[i][j] || dp[i][j-1]
     */
    public boolean isSubsequence0(String s, String t) {
        if (t == null) {
            return s == null;
        }
        int m = s.length();
        int n = t.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        //初始化第一行
        for (int i = 0; i <= n; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                dp[i][j] = dp[i][j] || dp[i][j - 1];
            }
        }
        return dp[m][n];
    }


    public boolean isSubsequence1(String s, String t) {
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