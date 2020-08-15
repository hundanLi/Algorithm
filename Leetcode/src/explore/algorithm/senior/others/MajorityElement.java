package explore.algorithm.senior.others;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-11 16:00
 **/
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (Integer e : map.keySet()) {
            if (map.get(e) > nums.length / 2) {
                return e;
            }
        }
        return Integer.MAX_VALUE;
    }

    /**
     * Boyer-Moore Voting Algorithm
     *
     */
    public int majorityElement2(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int n : nums) {
            if (count == 0) {
                candidate = n;
            }
            count += (candidate == n) ? 1 : -1;
        }
        return candidate != null ? candidate : -1;
    }
}
