package problems.hash;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-23 19:18
 **/
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] map = new int[128];
        for (char c : s.toCharArray()) {
            map[c]++;
        }
        int len = 0;
        for (int count: map) {
            if (count > 1) {
                if (count % 2 == 0) {
                    len += count;
                } else {
                    len += (count - 1);
                }
            }
        }
        if (len < s.length()) {
            len++;
        }
        return len;
    }
}
