package explore.algorithm.high.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-03 08:53
 * 思路：table[i]表示i=平方数之和的最小个数
 **/
public class NumSquares {
    public int numSquares(int sum) {
        int[] table = new int[sum + 1];
        for (int i = 1; i <= sum; i++) {
            int sqrt = (int) Math.sqrt(i);
            //本身是否平方数
            if (sqrt * sqrt == i) {
                table[i] = 1;
                continue;
            }
            //寻找包含最小个数的平方数组合
            int begin = 1;
            int end = i - 1;
            table[i] = Integer.MAX_VALUE;
            while (begin <= end) {
                int n = table[begin] + table[end];
                if (n < table[i]) {
                    table[i] = n;
                }
                begin++;
                end--;
            }
        }
        return table[sum];
    }

    private int[] squareNum(int sum) {
        int len = (int) Math.sqrt(sum);
        int[] squares = new int[len + 1];
        for (int i = 0; i < len + 1; i++) {
            squares[i] = (i + 1) * (i + 1);
        }
        return squares;
    }

    class Solution {
        //根据四平方数和定理 可能结果只有 1 2 3 4
        //时间复杂度 最坏情况 O(sqrt(n)*log(n))

        public int numSquares(int n) {
            if (n == 0) {
                return 0;
            }
            while (n % 4 == 0) {
                n /= 4;
            }
            if (n % 8 == 7) {
                return 4;
            }
            for (int a = 0; a * a <= n; ++a) {
                int b = (int) Math.sqrt(n - a * a);
                if (a * a + b * b == n) {
                    if (a == 0 || b == 0) {
                        return 1;
                    } else {
                        return 2;
                    }
                }
            }
            return 3;
        }
    }
}

