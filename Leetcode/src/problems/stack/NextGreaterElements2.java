package problems.stack;

import java.util.Stack;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-22 22:07
 **/
public class NextGreaterElements2 {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        // 可以使用数组翻倍来模拟循环数组
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            ans[i % n] = stack.isEmpty() ? -1 : stack.pop();
            stack.push(nums[i % n]);
        }
        return ans;
    }
}
