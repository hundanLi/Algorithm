package problems.array;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-23 11:18
 **/
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 2) {
            return nums.length;
        }
        int i = 1;
        int len = nums.length;
        for (int j = 2; j < len; j++) {
            if (nums[j] == nums[i - 1]) {
                continue;
            }
            nums[++i] = nums[j];
        }
        return i + 1;
    }
}
