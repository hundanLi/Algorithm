package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-23 20:38
 **/
public class FindNumberOfLIS {
    /**
     * 思路：
     * 设Tuple类型的dp[i].len和dp[i].num 分别表示以nums[i]结尾的最长递增子序列的长度和个数，则
     *      dp[i].len = max(dp[j].len + 1) for j <- 0 to i-1 if num[i] > num[j]
     *      dp[i].num = sum(dp[j].num) for j  satisfies the upon condition
     */
    public static int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Tuple[] dp = new Tuple[nums.length];
        dp[0] = new Tuple(1, 1);

        for (int i = 1; i < nums.length; i++) {
            int curLen = 1;
            int curNum = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j].len >= curLen) {
                        curLen = dp[j].len + 1;
                        curNum = dp[j].num;
                    } else if (dp[j].len == curLen - 1) {
                        curNum += dp[j].num;
                    }
                }
            }
            dp[i] = new Tuple(curLen, curNum);
        }
        int maxLen = 1;
        int maxNum = 1;
        for (int i = 1; i < dp.length; i++) {
            if (dp[i].len > maxLen) {
                maxLen = dp[i].len;
                maxNum = dp[i].num;
            } else if (dp[i].len == maxLen){
                maxNum += dp[i].num;
            }
        }
        return maxNum;
    }

    static class Tuple{
        int len;
        int num;

        Tuple(int len, int num) {
            this.len = len;
            this.num = num;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3, 5, 4, 7, 2};
        int number = findNumberOfLIS(nums);
        System.out.println(number);

    }
}
