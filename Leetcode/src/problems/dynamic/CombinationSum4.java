package problems.dynamic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-17 20:10
 **/
public class CombinationSum4 {

    public int combinationSum4(int[] num, int target) {
        if (num == null || num.length == 0) {
            return 0;
        }
        return dp1(num, target);
    }

    /**
     * O(N^2)复杂度的dp算法：
     * 设dp[i]表示和为i的组合个数，则
     * dp[i] = sum(dp[j]) for j <- 0 to i-1 if (i-j) in numSet
     */
    private int dp0(int[] num, int target) {

        int[] dp = new int[target + 1];
        dp[0] = 1;
        Set<Integer> set = new HashSet<>(num.length);
        for (int e : num) {
            set.add(e);
        }
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < i; j++) {
                if (set.contains(i - j)) {
                    dp[i] += dp[j];
                }
            }
        }
        return dp[target];
    }

    /**
     * 改进型dp
     */
    private int dp1(int[] num, int target) {

        Arrays.sort(num);
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int n: num) {
                if (n > i) {
                    break;
                }
                dp[i] += dp[i - n];
            }
        }
        return dp[target];
    }

    private int dfs(int[] num, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return dfs(num, target, dp);
    }

    /**
     * @param num   数组元素
     * @param target    目标和
     * @param dp    和是1->target的组合数
     * @return  dp[target]
     */
    private int dfs(int[] num, int target, int[] dp) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for (int n : num) {
            if (n <= target) {
                res += dfs(num, target - n, dp);
            }
        }
        dp[target] = res;
        return res;
    }

}
