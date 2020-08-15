package problems.array;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-27 09:15
 **/
public class MinSubArrayLen {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int minLen = Integer.MAX_VALUE;
        int begin = 0;
        int end;
        int sum = 0;
        for (end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= s) {
                minLen = Math.min(minLen, end - begin + 1);
                sum -= nums[begin];
                begin++;
            }
        }
        if (minLen != Integer.MAX_VALUE) {
            return minLen;
        } else {
            return 0;
        }
    }
}
