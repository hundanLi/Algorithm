package problems.dynamic;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-20 00:56
 **/
public class numberOfArithmeticSlicesII {

    /**
     * 设dp[i](key) 表示以num[i]结尾的以key为差的等差子序列（长度>1）的个数,则
     *  dp[i](key) += dp[j](key) + 1 for j <- 0 to i-1
     *  那么以num[i]结尾的等差子序列（长度>2）的个数 res[i] = sum(dp[j](num[i] - num[j])) for j <- 0 to i-1
     */
    public static int numberOfArithmeticSlices(int[] num) {
        if (num == null || num.length < 3) {
            return 0;
        }
        long[] longNum = new long[num.length];
        for (int i = 0; i < num.length; i++) {
            longNum[i] = num[i];
        }
        Map<Long, Integer>[] dp = new HashMap[num.length];
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            dp[i] = new HashMap<>(16);
            for (int j = 0; j < i; j++) {
                long diff = longNum[i] - longNum[j];
                int count = dp[j].getOrDefault(diff, 0);
                dp[i].put(diff, dp[i].getOrDefault(diff, 0) + count + 1);
                sum += count;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
//        int[] num = {1, 2, 3, 4, 5, 7, 9, 10, 11};
//        int[] num = {0, 1, 2, 2, 2};
        int[] num = {0, 2000000000, -294967296};
//        int[] num = {1, 1, 1, 1, 1};
        int number = numberOfArithmeticSlices(num);
        System.out.println(number);

    }
}
