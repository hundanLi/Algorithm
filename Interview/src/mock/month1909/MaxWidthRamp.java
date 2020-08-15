package mock.month1909;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-04 10:04
 **/
public class MaxWidthRamp {
    /**
     *  排序
     */
    public int maxWidthRamp(int[] nums) {
        int max = 0;
        Integer[] index = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, Comparator.comparingInt(i -> nums[i]));
        int min = nums.length;
        for (Integer i : index) {
            max = Math.max(max, i - min);
            min = Math.min(min, i);
        }
        return max;
    }

    /**
     * 单调栈
     */
    public int maxWidthRamp1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        Stack<Integer> subStack = new Stack<>();
        subStack.push(0);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[subStack.peek()]) {
                subStack.push(i);
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!subStack.isEmpty() && nums[i] >= nums[subStack.peek()]) {
                max = Math.max(max, i - subStack.pop());
            }
        }
        return max;
    }

}
