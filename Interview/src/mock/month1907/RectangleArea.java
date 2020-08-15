package mock.month1907;

import java.util.Stack;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-21 11:58
 **/
public class RectangleArea {
    public static int largestRectangleArea(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
//        return oN2(nums);
        return stack(nums);
    }

    /**
     * O（N^2）复杂度揭发
     */
    private static int oN2(int[] nums) {
        int maxArea = 0;
        int minHeight;
        for (int i = 0; i < nums.length; i++) {
            minHeight = nums[i];
            for (int j = i; j < nums.length; j++) {
                minHeight = Math.min(minHeight, nums[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }


    /**
     * O(N logN)
     */
    public static int recursive(int[] nums, int begin, int end) {

        if (begin > end) {
            return 0;
        }
        int minIdx = begin;
        for (int i = begin; i <= end; i++) {
            if (nums[minIdx] > nums[i]) {
                minIdx = i;
            }
        }
        return Math.max(nums[minIdx] * (end - begin + 1),
                Math.max(recursive(nums, begin, minIdx - 1),
                        recursive(nums, minIdx + 1, end)));
    }

    /**
     * 使用栈
     * O（N）
     */
    public static int stack(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        int height;
        for (int i = 0; i < nums.length; i++) {
            while (stack.peek() != -1 && nums[stack.peek()] >= nums[i]) {
                height = nums[stack.pop()];
                maxArea = Math.max(maxArea, height * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            height = nums[stack.pop()];
            maxArea = Math.max(maxArea, height * (nums.length - stack.peek() - 1));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1};
        System.out.println(largestRectangleArea(nums));
    }
}
