package problems.dynamic;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-17 00:00
 * 思路：最长递增子序列算法
 **/
public class MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, Comparator.comparingInt(o -> o[0]));
        int[] dp = new int[envelopes.length];
        int max = 0;
        for (int i = 0; i < envelopes.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            if (envelopes.length < 2) {
                return envelopes.length;
            }
            Enve[] enves = new Enve[envelopes.length];
            for (int i = 0; i < envelopes.length; i++) {
                enves[i] = new Enve(envelopes[i][0], envelopes[i][1]);
            }
            Arrays.sort(enves);
            int res = 0;
            int[] dp = new int[enves.length];
            for (Enve e : enves) {
                int j = Arrays.binarySearch(dp, 0, res, e.height);
                if (j < 0)
                    j = -(j + 1);
                dp[j] = e.height;
                if (res == j)
                    res++;
            }
            return res;
        }

        class Enve implements Comparable<Enve>{
            int width;
            int height;
            public Enve(int width, int height) {
                this.width = width;
                this.height = height;
            }

            public int compareTo(Enve a) {
                if (this.width == a.width) {
                    return a.height - this.height;
                } else {
                    return this.width - a.width;
                }
            }
        }
    }
}
