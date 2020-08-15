package explore.algorithm.senior.dp;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-08 18:37
 **/
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int maxPre = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxPre = Math.max(maxPre, dp[j]);
                }
            }
            dp[i] = maxPre + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
