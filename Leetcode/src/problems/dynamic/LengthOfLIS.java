package problems.dynamic;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-15 16:04
 * 思路：设dp[i] 是以num[i]结尾的最长上升子序列的长度，则
 * dp[i] = max(dp[i-j] + 1) for j in [0:i-1] and num[j] < num[i]
 **/
public class LengthOfLIS {
    public int lengthOfLIS(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int n = num.length;
        int[] dp = new int[n];
        int max = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (num[j] < num[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int lengthOfLIS0(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        Stack<Integer> minStack = new Stack<>();
        int max = 1;
        for (int n : num) {
            if (minStack.size() <= 0) {
                minStack.push(n);
            } else {
                while (minStack.size() > 0 && minStack.peek() >= n) {
                    minStack.pop();
                }
                minStack.push(n);
                max = Math.max(max, minStack.size());
            }
        }
        return max;
    }

    static class Solution {
        static int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            int len = 0;
            for (int num : nums) {
                int i = Arrays.binarySearch(dp, 0, len, num);
                if (i < 0) {
                    i = -(i + 1);
                }
                dp[i] = num;
                if (i == len) {
                    len++;
                }
            }
            return len;
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int length = Solution.lengthOfLIS(num);
        System.out.println(length);

    }
}
