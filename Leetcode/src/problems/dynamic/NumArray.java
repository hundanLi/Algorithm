package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-15 18:36
 **/
public class NumArray {
    private int[] rangeSum;
    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        rangeSum = new int[n];
        rangeSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            rangeSum[i] = rangeSum[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return rangeSum[j];
        }
        return rangeSum[j] - rangeSum[i - 1];
    }

}
