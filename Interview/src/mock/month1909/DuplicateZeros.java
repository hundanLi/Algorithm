package mock.month1909;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-08 09:35
 **/
public class DuplicateZeros {
    public void duplicateZeros(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int numZero = 0;
        int tail;
        boolean equal = false;
        for (tail = 1; tail <= nums.length; tail++) {
            if (nums[tail - 1] == 0) {
                numZero++;
            }
            if (numZero + tail == nums.length) {
                equal = true;
                break;
            } else if (numZero + tail > nums.length) {
                break;
            }
        }


        int j = nums.length - 1;
        for (int i = tail - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                if (i == tail - 1 && !equal) {
                    nums[j--] = nums[i];
                    continue;
                }
                nums[j--] = 0;
                nums[j--] = 0;
            } else {
                nums[j--] = nums[i];
            }
        }

    }
}
