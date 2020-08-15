package problems.bitwise;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-10 13:49
 **/
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        int total = (nums.length + 1) * nums.length / 2;
        return total - sum;
    }

    public int missingNumber2(int[] nums) {
        int mask = 0;
        for (int i = 1; i <= nums.length; i++) {
            mask ^= i;
        }
        for (int n : nums) {
            mask ^= n;
        }
        return mask;
    }
}
