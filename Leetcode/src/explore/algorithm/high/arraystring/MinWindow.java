package explore.algorithm.high.arraystring;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-16 23:06
 **/
public class MinWindow {
    public String minWindow(String s, String t) {
        String rs = "";
        if (s == null || t == null) {
            return rs;
        }
        int[] hash = new int[256];
        char[] tChars = t.toCharArray();
        char[] sChars = s.toCharArray();
        for (char c : tChars) {
            hash[c]++;
        }
        int l = 0;
        int r = 0;
        int match = 0;
        int minLen = Integer.MAX_VALUE;
        while (r < s.length()) {
            char rc = sChars[r];
            hash[rc]--;
            if (hash[rc] >= 0) {
                match++;
            }
            while (match == t.length()) {
                while (hash[sChars[l]] < 0) {
                    hash[sChars[l++]]++;
                }
                int len = r - l + 1;
                if (len < minLen) {
                    rs = s.substring(l, r + 1);
                    minLen = len;
                }
                match--;
                hash[sChars[l++]]++;
            }
            r++;
        }
        return rs;
    }
}