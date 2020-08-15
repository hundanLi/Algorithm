package problems.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-20 16:21
 **/
public class UniqueOccurrences {
    public boolean uniqueOccurrences(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (Integer n : map.values()) {
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
        return true;
    }
}
