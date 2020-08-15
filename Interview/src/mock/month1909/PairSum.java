package mock.month1909;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-03 09:41
 **/
public class PairSum {
    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
