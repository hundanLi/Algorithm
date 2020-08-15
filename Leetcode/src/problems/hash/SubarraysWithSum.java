package problems.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-21 21:45
 **/
public class SubarraysWithSum {
    public static int numSubarraysWithSum(int[] nums, int s) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>(nums.length + 1);
        map.put(0, 1);
        int ans = 0;
        for (int num : nums) {
            sum += num;
            ans += map.getOrDefault(sum - s, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
