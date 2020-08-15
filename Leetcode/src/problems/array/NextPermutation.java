package problems.array;


/**
 * @author li
 * @version 1.0
 * @date 2019-05-21 16:13
 **/
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        int i;
        for (i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                // 向右搜索比num[i-1]大的最小值的索引
                int j = i + 1;
                while (j < nums.length) {
                    if (nums[j] <= nums[i - 1]) {
                        break;
                    }
                    j++;
                }
                swap(nums, i - 1, j - 1);
                break;
            }
        }

        reverse(nums, i, nums.length - 1);
    }

    private void reverse(int[] nums, int beginIndex, int endIndex) {
        while (beginIndex < endIndex) {
            swap(nums, beginIndex++, endIndex--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
