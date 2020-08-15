package explore.algorithm.high.arraystring;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-14 14:54
 **/
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int len = nums.length;
        //将大于等于1的数字与下标对应起来
        for (int i = 0; i < len; i++) {
            if (i != nums[i] - 1) {
                if (nums[i] > 0 && nums[i] < len && nums[nums[i] - 1] != nums[i]) {
                    swap(nums, i, nums[i] - 1);
                    i--;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] - 1 != i) {
                return i + 1;
            }
        }
        return len + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
