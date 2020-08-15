package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-10 20:58
 * 思路：
 *      设dp[i][j]表示s[0:i-1]的子序列中t[0:j-1]出现的次数，则
 *      1.若s[i-1] == t[j-1] => dp[i][j] = dp[i-1][j-1] (用s[i-1]与t[j-1]配对) + dp[i-1][j](抛弃s[i-1],不用s[i-1]与t[j-1]配对)
 *      2.若s[i-1] != t[j-1] => dp[i-1][j] (直接抛弃s[i-1],不用s[i-1]与t[j-1]配对)
 **/
public class NumDistinct {
    public int numDistinct(String s, String t) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m + 1][n + 1];
        //初始化dp[i][0] = 1
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        //按t[0:0] => t[0:n]的顺序依次匹配
        for (int j = 1; j <= n; j++) {
            //因为当i<j时 s[0:i-1] 的长度比t[0:j-1]小，所以可以忽略
            for (int i = j; i <= m; i++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}
