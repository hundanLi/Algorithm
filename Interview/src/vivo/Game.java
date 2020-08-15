package vivo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-11 16:26
 **/
public class Game {

    public int Game() {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int[] input = parseInts(inputStr.split(" "));
        int output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static int solution(int[] nums) {
        int[][][] dp = new int[nums.length][nums.length][nums.length];
        return dfs(nums, 0, nums.length - 1, 0, dp);
    }

    private static int dfs(int[] nums, int begin, int end, int s, int[][][] dp) {
        // [begin, end]子数组
        // s是与nums[begin]左相邻的相同数字个数
        if (begin > end) {
            return 0;
        }
        if (dp[begin][end][s] > 0) {
            return dp[begin][end][s];
        }
        while (begin < end && nums[begin] == nums[begin + 1]) {
            begin++;
            s++;
        }
        int res = (1 + s) * (1 + s) + dfs(nums, begin + 1, end, 0, dp);
        for (int m = begin + 1; m <= end; m++) {
            // 如果nums[begin] == nums[i]，那么先清除[begin+1, m - 1]
            // 使得nums[begin]和nums[m]相邻
            if (nums[m] == nums[begin]) {
                //清除[begin + 1, m-1]后，nums[m]相邻左边就有s+1个数字与之相同
                res = Math.max(
                        res,
                        dfs(nums, begin + 1, m - 1, 0, dp) + dfs(nums, m, end, s + 1, dp));
            }
        }
        dp[begin][end][s] = res;
        return res;
    }

}
