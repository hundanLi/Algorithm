package mock.month1909;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-22 10:00
 **/
public class FactoredBinaryTrees {
    public static int numFactoredBinaryTrees(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        Map<Integer, Long> map = new HashMap<>(nums.length);
        long ans = 0;
        int mod = 1000_000_007;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 1L);
            for (int j = 0; j < i; j++) {
                int d = nums[i] / nums[j];
                if (d * nums[j] == nums[i] && map.containsKey(d)) {
                    long leftSub = map.get(nums[j]);
                    long rightSub = map.get(d);
                    long update = leftSub * rightSub + map.get(nums[i]);
                    update %= mod;
                    map.put(nums[i], update);
                }
            }
            ans += map.get(nums[i]);
        }
        return (int) (ans % mod);
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 5, 10};
        System.out.println(numFactoredBinaryTrees(nums));
    }
}
