package mock.month1909;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-17 10:36
 **/
public class SmallestRangeII {
    public int smallestRangeII(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int ans = nums[n - 1] - nums[0];
        for (int i = 1; i < nums.length; i++) {
            int min = Math.min(nums[0] + k, nums[i] - k);
            int max = Math.max(nums[n - 1] - k, nums[i - 1] + k);
            ans = Math.min(ans, max - min);
        }
        return ans;

    }
}
