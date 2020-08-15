package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-22 22:29
 **/
public class CountSubstrings {
    /**
     *  思路：
     *      设dp[i]表示以以字符s[i]结尾的回文子串的个数，isPalindrome[j][i]表示s[j:i]是否回文子串，
     *      则：
     *          dp[i] += dp[j] if s[i] == s[j] && isPalindrome[j+1][i-1] for j <- i to 0
     *      细节：
     *          先以O(n)遍历字符串处理长度小于3的子串，
     *          再以O(n^2)的复杂度处理长度大于等于3的子串。
     *      空间优化：
     *          dp可以省去
     */
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        count++;
        isPalindrome[0][0] = true;
        for (int i = 1; i < s.length(); i++) {
            count++;
            isPalindrome[i][i] = true;
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
                isPalindrome[i - 1][i] = true;
            }
        }

        for (int i = 2; i < s.length(); i++) {
            for (int j = i - 2; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && isPalindrome[j+1][i-1]) {
                    count++;
                    isPalindrome[j][i] = true;
                }
            }
        }
        return count;
    }
}
