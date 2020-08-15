package mock.month1908;

import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2019-08-31 10:21
 **/
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> indexMap = new HashMap<>(16);
        int begin = 0;
        int end = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (indexMap.containsKey(c) && indexMap.get(c) >= begin) {
                max = Math.max(max, end - begin + 1);
                begin = indexMap.get(c) + 1;
            }
            indexMap.put(c, i);
            end = i;
        }
        max = Math.max(max, end - begin + 1);
        return max;
    }

    public static void main(String[] args) {
        String s = "abba";
        LongestSubstring longestSubstring = new LongestSubstring();
        System.out.println(longestSubstring.lengthOfLongestSubstring(s));

    }
}
