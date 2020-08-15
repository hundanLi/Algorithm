package mock.month1908;

/**
 * @author li
 * @version 1.0
 * @date 2019-08-26 10:33
 **/
public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else if (num <= max) {
                max = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
