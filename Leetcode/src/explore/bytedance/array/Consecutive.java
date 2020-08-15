package explore.bytedance.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-09 12:54
 **/
public class Consecutive {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                Integer llen = map.getOrDefault(num - 1, 0);
                Integer rlen = map.getOrDefault(num + 1, 0);
                int clen = llen + rlen + 1;
                map.put(num, clen);
                map.put(num - llen, clen);
                map.put(num + rlen, clen);
                max = max > clen ? max : clen;
            }
        }
        return max;
    }
}
