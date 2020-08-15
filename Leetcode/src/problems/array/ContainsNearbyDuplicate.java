package problems.array;

import java.util.HashMap;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-27 10:50
 **/
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int lastIndex = map.get(nums[i]);
                if (i - lastIndex <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }


    /**
     * 滑动窗口
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        return false;
    }
}
