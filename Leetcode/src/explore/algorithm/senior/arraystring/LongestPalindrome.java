package explore.algorithm.senior.arraystring;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-25 13:37
 **/
public class LongestPalindrome {
    /**
     * 从两边往回收
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int tmpStart = 0; tmpStart < s.length(); tmpStart++) {
            int tmpEnd = s.length() - 1;
            while (tmpStart <= tmpEnd) {
                if (s.charAt(tmpStart) == s.charAt(tmpEnd)) {
                    int j = tmpStart;
                    int k = tmpEnd;
                    while (j <= k) {
                        if (s.charAt(j) == s.charAt(k)) {
                            j++;
                            k--;
                        } else {
                            break;
                        }
                    }
                    if (j > k) {
                        if (tmpEnd - tmpStart > end - start) {
                            start = tmpStart;
                            end = tmpEnd;
                        }
                    }
                }
                tmpEnd--;
            }

        }
        for (int tmpEnd = s.length() - 1; tmpEnd >= 0; tmpEnd--) {
            int tmpStart = 0;
            while (tmpEnd >= tmpStart) {
                if (s.charAt(tmpEnd) != s.charAt(tmpStart)) {
                    int j = tmpEnd;
                    int k = tmpStart;
                    while (j >= k) {
                        if (s.charAt(j) == s.charAt(k)) {
                            j--;
                            k++;
                        } else {
                            break;
                        }
                    }
                    if (j < k) {
                        if (tmpEnd - tmpStart > end - start) {
                            start = tmpStart;
                            end = tmpEnd;
                        }
                    }
                }
                tmpStart++;
            }

        }
        return s.substring(start, end + 1);
    }


    /**
     * 从中间向两边扩展
     */
    public String longestPalindrome2(String s) {
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


    public static void main(String[] args) {
        String test = "abcdbbfcba";
        String s = longestPalindrome(test);
        System.out.println(s);
    }
}
