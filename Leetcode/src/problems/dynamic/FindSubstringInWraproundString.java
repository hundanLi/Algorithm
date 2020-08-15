package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-20 21:03
 **/
public class FindSubstringInWraproundString {

    /**
     * 思路：
     *      设dp[i] 表示s中以 ('a' + i) 字母结尾且满足要求的最长子串长度（也是以该字母结尾的子串个数）；
     *      满足要求的条件是：s[i] - s[i-1] == (1 || -25)
     */
    public int findSubstringInWraproundString(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[26];
        dp[s.charAt(0) - 'a'] = 1;
        int count = 1;
        for (int i = 1; i < dp.length; i++) {
            int diff = s.charAt(i) - s.charAt(i - 1);
            if (diff == 1 || diff == -25) {
                count ++;
            } else {
                count = 1;
            }
            dp[s.charAt(i) - 'a'] = Math.max(dp[s.charAt(i) - 'a'], count);
        }
        int sum = 0;
        for (int i : dp) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "zaba";

    }
}
