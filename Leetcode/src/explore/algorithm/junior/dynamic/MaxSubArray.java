package explore.algorithm.junior.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-20 23:28
 **/
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (maxSum < sum) {
                maxSum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}
