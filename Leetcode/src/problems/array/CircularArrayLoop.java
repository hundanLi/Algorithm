package problems.array;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-29 10:56
 **/
public class CircularArrayLoop {
    public static boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int cirLen;
        int sign;
        for (int i = 0; i < nums.length; i++) {
            sign = 1;
            cirLen = 0;
            if (nums[i] < 0) {
                sign = -1;
            }
            int k = i;
            do {
                cirLen++;
                k = (k + nums[k]) % nums.length;
                if (k < 0) {
                    k = k + nums.length;
                }
            } while (cirLen <= nums.length && k != i && nums[k] * sign > 0);
            if (cirLen > 1 && cirLen <= nums.length && nums[k] * sign > 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1};
        System.out.println(circularArrayLoop(nums));
    }
}
