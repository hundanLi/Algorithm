package mock.month1907;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-20 10:14
 **/
public class LargestPerimeter {
    public static int largestPerimeter(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            int l = i - 2;
            int r = i - 1;
            if (nums[l] + nums[r] > nums[i]) {
                max = Math.max(max, nums[l] + nums[r] + nums[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 2, 3};
        System.out.println(largestPerimeter(nums));
    }
}
