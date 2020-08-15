package problems.tree;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-27 12:18
 **/
public class NumArray {
    private long[] sums;
    private int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        sums = new long[nums.length];
        long sum = 0L;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
    }

    public void update(int i, int val) {
        int old = nums[i];
        nums[i] = val;
        long dif = (long) val - (long) old;
        for (int j = i; j < sums.length; j++) {
            sums[j] += dif;
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return (int) sums[j];
        } else {
            return (int) (sums[j] - sums[i - 1]);
        }
    }
}
