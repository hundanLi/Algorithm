package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-04 21:42
 * 思路： 设dp[i][j]表示从s[i]到s[j]是否是回文字符串，推导式如下
 * 1.若s[i] == s[j], 则 dp[i][j] = dp[i+1][j-1];
 * 2.若s[i] != s[j], 则dp[i][j] = false;
 * <p>
 * 实现细节：
 * 1.初始化边界值dp[i][i] = true
 * 2.计算dp[i][i+1]
 * 3.依次计算长度为3,4,5...n的字符串是否回文串
 * 结果: dp[0][n-1]
 **/
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int l = 0;
        int r = 0;
        int len = s.length();
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        //第1 第2两步
        for (int i = 0; i < len - 1; i++) {
            dp[i][i] = true;
            if (chars[i] == chars[i + 1]) {
                dp[i][i + 1] = true;
                l = i;
                r = i + 1;
            }
        }
        dp[len - 1][len - 1] = true;

        //第三步
        for (int interval = 2; interval < len; interval++) {
            //枚举起点值
            for (int i = 0; i < len - interval; i++) {
                int j = i + interval;
                if (chars[i] == chars[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    l = i;
                    r = j;
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return s.substring(l, r + 1);
    }

    static class Solution {
        /**
         * 从中间向两边扩展
         */
        public String longestPalindrome(String s) {
            int n = s.length();

            int[] range = new int[2];
            for (int i = 0; i < n; i++) {
                i = helper(s, range, i);
            }

            return s.substring(range[0], range[1]);
        }

        private int helper(String s, int[] range, int i) {
            int lo = i;
            int hi = i;
            while (hi < s.length() - 1 && s.charAt(hi) == s.charAt(hi + 1)) {
                hi++;
            }

            int ret = hi;
            while (lo > 0 && hi < s.length() - 1 && s.charAt(lo - 1) == s.charAt(hi + 1)) {
                lo--;
                hi++;
            }

            if (hi - lo + 1 > range[1] - range[0]) {
                range[0] = lo;
                range[1] = hi + 1;
            }

            return ret;
        }

    }
}
