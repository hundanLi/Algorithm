package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-10 18:51
 **/
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];
        int curSum = 0;
        for (int n : nums) {
            curSum += n;
            maxSum = Math.max(maxSum, curSum);
            if (curSum < 0) {
                curSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, -4};
        System.out.println(new MaxSubArray().maxSubArray(nums));
    }
}
