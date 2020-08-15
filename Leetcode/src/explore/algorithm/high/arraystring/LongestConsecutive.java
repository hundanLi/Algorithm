package explore.algorithm.high.arraystring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-15 19:11
 **/
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int leftLen = map.getOrDefault(n - 1, 0);
                int rightLen = map.getOrDefault(n + 1, 0);
                int curLen = leftLen + rightLen + 1;
                map.put(n, curLen);
                map.put(n - leftLen, curLen);
                map.put(n + rightLen, curLen);
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }
}
