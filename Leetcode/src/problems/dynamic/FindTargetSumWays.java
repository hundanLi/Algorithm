package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-21 21:13
 **/
public class FindTargetSumWays {
    private int count = 0;
    public int findTargetSumWays(int[] num, int target) {
        return dp(num, target);
    }

    /**
     * 暴力搜索
     */
    private void dfs(int[] num, int index, int target) {
        if (index == num.length) {
            if (target == 0) {
                count++;
            }
        } else {
            dfs(num, index + 1, target + num[index]);
            dfs(num, index + 1, target - num[index]);
        }
    }

    /**
     * 原问题等同于： 找到nums一个正子集和一个负子集，使得总和等于target
     *
     * 我们假设P是正子集，N是负子集 例如： 假设nums = [1, 2, 3, 4, 5]，target = 3，一个可能的解决方案是+1-2+3-4+5 = 3 这里正子集P = [1, 3, 5]和负子集N = [2, 4]
     *
     * 那么让我们看看如何将其转换为子集求和问题：
     *
     *                   sum(P) - sum(N) = target
     * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
     *                        2 * sum(P) = target + sum(nums)
     * 因此，原来的问题已转化为一个求子集的和问题： 找到nums的一个子集 P，使得sum(P) = (target + sum(nums)) / 2
     *
     * 请注意，上面的公式已经证明target + sum(nums)必须是偶数，否则输出为0
     */
    private int dp(int[] num, int target) {
        int sum = 0;
        for (int n : num) {
            sum += n;
        }
        int s = target + sum;
        if ((s & 1) == 1 || sum < target) {
            return 0;
        }
        return subSetSum(num, s >> 1);
    }

    /**
     * 设dp[i]表示num的累加和为i的子集数目，则
     * 对于每个元素e，当纳入这个元素时，dp[i] += dp[i-e]
     * 初始化dp[0]=1（空子集和为0）
     */
    private int subSetSum(int[] num, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int n : num) {
            for (int i = sum; i >= n; i--) {
                dp[i] += dp[i - n];
            }
        }
        return dp[sum];
    }

}
