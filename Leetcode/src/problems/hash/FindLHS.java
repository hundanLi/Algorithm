package problems.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-23 00:19
 **/
public class FindLHS {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Integer k : map.keySet()) {
            int minCount = map.get(k);
            int maxCount = map.getOrDefault(k + 1, 0);
            if (maxCount > 0) {
                ans = Math.max(ans, minCount + maxCount);
            }
        }
        return ans;
    }
}
