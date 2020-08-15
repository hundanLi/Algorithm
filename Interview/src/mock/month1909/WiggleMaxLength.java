package mock.month1909;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-24 08:53
 **/
public class WiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int[] len = new int[nums.length];
        int[] diff = new int[nums.length];
        int max = 1;
        len[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                len[i] = len[i - 1];
                diff[i] = diff[i - 1];
            } else {
                if (diff[i - 1] == 0) {
                    len[i] = 2;
                    diff[i] = nums[i] - nums[i - 1] > 0 ? 1 : -1;
                } else {
                    diff[i] = nums[i] - nums[i - 1] > 0 ? 1 : -1;
                    if (diff[i] * diff[i - 1] < 0) {
                        len[i] = len[i - 1] + 1;
                    } else {
                        len[i] = len[i - 1];
                    }
                }
            }
            max = Math.max(max, len[i]);
        }
        return max;
    }
}
