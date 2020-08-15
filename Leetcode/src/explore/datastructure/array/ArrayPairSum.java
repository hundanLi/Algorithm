package explore.datastructure.array;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-15 09:49
 **/
public class ArrayPairSum {
    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);
        int sum = 0;
        int i = 0;
        while (i < nums.length) {
            sum += nums[i];
            i += 2;
        }
        return sum;
    }
}
