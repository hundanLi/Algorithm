package problems.tree;

import java.util.Stack;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-19 12:03
 **/
public class MctFromLeafValues {
    private int[][] maxVal;

    public int mctFromLeafValues(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int[][] dp = new int[n][n];
        maxVal = new int[n][n];
        for (int len = 2; len <= n; len++) {
            for (int j = 0; j <= n - len; j++) {
                for (int k = j; k < j + len - 1; k++) {
                    int val = dp[j][k] + dp[k + 1][j + len - 1] + max(arr, j, k) * max(arr, k + 1, j + len - 1);
                    if (dp[j][j + len - 1] == 0) {
                        dp[j][j + len - 1] = val;
                    } else {
                        dp[j][j + len - 1] = Math.min(dp[j][j + len - 1], val);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    private int max(int[] arr, int i, int j) {
        if (i < j && maxVal[i][j - 1] > 0) {
            maxVal[i][j] = Math.max(maxVal[i][j - 1], arr[j]);
            return maxVal[i][j];
        }
        int max = arr[i];
        for (int k = i + 1; k <= j; k++) {
            max = Math.max(max, arr[k]);
        }
        maxVal[i][j] = max;
        return max;
    }

    class Solution {
        public int mctFromLeafValues(int[] arr) {
            if (arr == null || arr.length == 0) {
                return 0;
            }
            Stack<Integer> stack = new Stack<>();
            stack.push(Integer.MAX_VALUE);
            int sum = 0;
            for (int leaf : arr) {
                while (stack.peek() <= leaf) {
                    int min = stack.pop();
                    sum += min * Math.min(stack.peek(), leaf);
                }
                stack.push(leaf);
            }
            while (stack.size() > 2) {
                sum += stack.pop() * stack.peek();
            }
            return sum;
        }
    }
}
