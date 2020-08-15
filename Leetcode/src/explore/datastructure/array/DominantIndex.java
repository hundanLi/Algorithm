package explore.datastructure.array;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-14 09:37
 **/
public class DominantIndex {
    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        for (int n : nums) {
            if (n < max) {
                if (n * 2 > max) {
                    return -1;
                }
            }
        }
        return index;
    }
}
