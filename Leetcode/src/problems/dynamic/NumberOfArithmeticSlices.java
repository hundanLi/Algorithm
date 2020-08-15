package problems.dynamic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-18 23:56
 **/
public class NumberOfArithmeticSlices {

    /**
     * 设dp[i]为以num[i]结尾的等差数列个数，则
     *  初始化dp[0] = dp[1] = 0;
     *  for i <- 2 to n
     *      dp[i] = dp[i-1] + 1 if num[i] - num[i-1] == num[i-1] - num[i-2]
     */
    public static int numberOfArithmeticSlices(int[] num) {
        if (num == null || num.length <= 2) {
            return 0;
        }
        int[] dp = new int[num.length];
        int sum = 0;
        for (int i = 2; i < num.length; i++) {
            if (num[i] - num[i - 1] == num[i - 1] - num[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5, 7, 9, 10, 11};
        int number = numberOfArithmeticSlices(num);
        System.out.println(number);

    }
}
