package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-10 19:43
 * 思路：
 * 设 dp[i][j] 表示s1[0:i-1] 和s2[0:j-1] 能否交错组成s3[0:i+j-2]， 则：
 * 1. s1[i-1] != s3[i+j-1] && s2[j-1] != s3[i+j-1]: dp[i][j] = false
 * 2. s1[i-1] == s3[i+j-1]: dp[i][j] = dp[i-1][j] || dp[i][j]
 * 3. s2[j-1] == s3[i+j-1]: dp[i][j] = dp[i][j-1] || dp[i][j]
 **/
public class IsInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s1.length() == 0) {
            return s2 == null ? s3 == null : s2.equals(s3);
        }
        if (s2 == null || s2.length() == 0) {
            return s1.equals(s3);
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                }
                if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbca";
        boolean interleave = new IsInterleave().isInterleave(s1, s2, s3);
        System.out.println(interleave);
    }
}
