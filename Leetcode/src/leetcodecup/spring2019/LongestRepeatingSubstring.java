package leetcodecup.spring2019;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-21 19:03
 **/
public class LongestRepeatingSubstring {
    /**
     * 设dp[i][j]表示分别以s[i]和s[j]开头的两个子串中的最长公共子子串的长度，则
     * 若s[i] == s[j] ==> dp[i][j] = 1 + dp[i+1][j+1]
     */
    public int longestRepeatingSubstring(String s) {
        int max = 0;
        int length = s.length();
        int[][] dp = new int[length][length + 1];
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
