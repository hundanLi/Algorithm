package problems.array;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-21 13:14
 **/
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int left;
        int right;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            left = i + 1;
            right = nums.length - 1;
            int curSum;
            int curDiff;

            while (left < right) {
                curSum = nums[i] + nums[left] + nums[right];
                curDiff = curSum - target;
                if (curDiff == 0) {
                    return target;
                }
                if (Math.abs(curDiff) < Math.abs(diff)) {
                    diff = curDiff;
                }
                if (curSum > target) {
                    right--;
                } else if (curSum < target) {
                    left++;
                }
            }
        }
        return diff + target;
    }
}
