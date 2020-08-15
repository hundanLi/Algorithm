package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-15 13:14
 **/
public class Robii {
    public static int rob(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int n = num.length;
        if (n == 1) {
            return num[0];
        } else if (n == 2) {
            return Math.max(num[0], num[1]);
        }
        int[] dp = new int[n - 1];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[0] = num[i];
            dp[1] = Math.max(num[i], num[(i + 1) % n]);
            int k = (i + 2) % n;
            for (int j = 2; j < n - 1; j++) {
                dp[j] = Math.max(dp[j - 1], dp[j - 2] + num[k]);
                k = (k + 1) % n;
            }
            max = Math.max(max, dp[n - 2]);
        }

        return max;
    }

    public static int robii(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int n = num.length;
        if (n == 1) {
            return num[0];
        }
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        dp1[0] = 0;
        dp1[1] = num[0];
        dp2[0] = 0;
        dp2[1] = num[1];
        for (int i = 2; i < n; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + num[i - 1]);
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + num[i]);

        }
        return Math.max(dp1[n - 1], dp2[n - 1]);
    }

    public static void main(String[] args) {
        int[] num = new int[]{2, 7, 9, 3, 1};
        int rob = robii(num);
        System.out.println(rob);
    }


    class Solution {
        public int rob(int[] nums) {
            if(nums == null || nums.length == 0)
                return 0;
            if(nums.length == 1)
                return nums[0];
            return Math.max(robHelp(0,nums.length-2,nums), robHelp(1,nums.length -1,nums));
        }

        private int robHelp(int l, int r , int[]nums){
            int include = 0;
            int exclude = 0;
            for(int k = l; k<=r;k++){
                int i = include;
                int e = exclude;
                include = e +nums[k];
                exclude = Math.max(i,e);
            }
            return Math.max(include, exclude);
        }
    }
}
