package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-17 19:26
 **/
public class WiggleMaxLength {
    public static int wiggleMaxLength(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return 1;
        }

        int[] dp = new int[num.length];
        int[] diff = new int[num.length];

        dp[0] = 1;
        dp[1] = num[1] == num[0] ? 1 : 2;
        diff[1] = num[1] - num[0];
        int max = Math.max(dp[0], dp[1]);
        for (int i = 2; i < num.length; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (dp[i] < dp[j] + 1 && ((num[i] - num[j]) * diff[j] < 0 || (dp[j] == 1 && num[i] != num[j]))) {
                    dp[i] = dp[j] + 1;
                    diff[i] = num[i] - num[j];
                }
            }
            if (num[i] != num[0]) {
                if (dp[i] < 2) {
                    diff[i] = num[i] - num[0];
                    dp[i] = 2;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] num = {3, 3, 3, 2, 5};
        int maxLength = wiggleMaxLength(num);
        System.out.println(maxLength);

    }

    class Solution {
        public int wiggleMaxLength(int[] nums) {
            if(nums == null || nums.length == 0) return 0;
            int p = 1,q = 1;
            for(int i = 1;i<nums.length;++i){
                if(nums[i] > nums[i-1]){
                    p = q + 1;
                }else if(nums[i] < nums[i - 1]){
                    q = p + 1;
                }
            }
            return Math.max(p,q);
        }
    }
}
