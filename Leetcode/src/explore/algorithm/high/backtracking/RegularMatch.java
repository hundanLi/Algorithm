package explore.algorithm.high.backtracking;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-30 19:23
 **/
public class RegularMatch {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        //dp[i][j]表示p[1:i]和s[1:j]是否匹配
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;

        for (int i = 1; i < dp.length; i++) {
            //在开头的'*'可以匹配空字符串
            dp[i][0] = i > 1 && dp[i - 2][0] && p.charAt(i - 1) == '*';
            for (int j = 1; j < dp[0].length; j++) {
                if (p.charAt(i - 1) == '*') {
                    //'*'匹配零个或者多个字符
                    dp[i][j] = dp[i - 2][j] || (s.charAt(j - 1) == p.charAt(i - 2) || p.charAt(i - 2) == '.') && dp[i][j - 1];
                } else {
                    //s[1:i-1]和p[1:j-1]匹配且s[i]与p[j]匹配
                    dp[i][j] = dp[i - 1][j - 1] && (p.charAt(i - 1) == '.' || p.charAt(i - 1) == s.charAt(j - 1));
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}
