package explore.datastructure.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-09 11:26
 **/
public class NearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
