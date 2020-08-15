package explore.bytedance.array;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-09 11:30
 **/
public class LengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 1;
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                len++;
            } else {
                max = Math.max(max, len);
                len = 1;
            }
        }
        return max > len ? max : len;
    }

}
