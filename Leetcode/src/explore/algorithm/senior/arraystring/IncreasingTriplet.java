package explore.algorithm.senior.arraystring;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-25 14:42
 **/
public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= small) {
                small = n;
            } else if (n <= big) {
                big = n;
            } else {
                return true;
            }
        }
        return false;
    }
}
