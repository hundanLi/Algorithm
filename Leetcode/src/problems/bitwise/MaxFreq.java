package problems.bitwise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-16 14:58
 **/
public class MaxFreq {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<String, Integer> countMap = new HashMap<>();
        int maxFreq = 0;
        for (int i = 0; i <= s.length() - minSize; i++) {
            int mask = 0;
            int difLetters = 0;
            for (int j = i; j < i + minSize; j++) {
                int shift = 1 << s.charAt(j) - 'a';
                if ((mask & shift) == 0) {
                    difLetters++;
                    mask |= shift;
                }
                if (difLetters > maxLetters) {
                    break;
                }
            }
            if (difLetters <= maxLetters) {
                String substr = s.substring(i, i + minSize);
                int count = countMap.getOrDefault(substr, 0) + 1;
                countMap.put(substr, count);
                maxFreq = Math.max(count, maxFreq);
            }
        }
        return maxFreq;
    }

    public static void main(String[] args) {
        String str = "aababcaab";
        int maxLetters = 2;
        int minSize = 3;
        int maxSize = 4;
        System.out.println(new MaxFreq().maxFreq(str, maxLetters, minSize, maxSize));
    }
}
