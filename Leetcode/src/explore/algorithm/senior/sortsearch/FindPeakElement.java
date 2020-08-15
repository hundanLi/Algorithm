package explore.algorithm.senior.sortsearch;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-27 14:00
 **/
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 ) {
                if (i + 1 < nums.length) {
                    if (nums[i] > nums[i + 1]) {
                        return i;
                    }
                } else {
                    return i;
                }
            } else if (i == nums.length - 1) {
                if (nums[i] > nums[i - 1]) {
                    return i;
                }
            } else if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                    return i;
                }
            }

        return - 1;

    }
}
