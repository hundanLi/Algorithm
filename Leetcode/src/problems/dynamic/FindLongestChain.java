package problems.dynamic;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-22 21:14
 **/
public class FindLongestChain {
    /**
     * 思路：
     *  预备工作：对数对进行排序
     *  设dp[i] 表示以pairs[i]结尾的最长链的长度，则
     *      dp[i] = 1 + dp[j] if pairs[j][1] < pairs[i][0]
     *      j是小于i且满足上面if条件的最大值
     */
    public int findLongestChain0(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }
        Arrays.sort(pairs, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        int[] dp = new int[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = 1 + dp[j];
                    break;
                }
            }
        }
        return dp[pairs.length - 1];
    }

    public int findLongestChain1(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));

        int res = 0;
        int end = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            if (pair[0] > end) {
                res++;
                end = pair[1];
            }
        }
        return res;
    }
}
