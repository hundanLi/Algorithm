package explore.algorithm.junior.others;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-23 20:56
 **/
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int missingNumber = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missingNumber ^= i ^ nums[i];
        }
        return missingNumber;
    }

    public int missingNumber2(int[] nums) {
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }
}
