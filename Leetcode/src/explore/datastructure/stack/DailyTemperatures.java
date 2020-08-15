package explore.datastructure.stack;

import java.util.Stack;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-05 10:50
 **/
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temp.length];
        for (int i = temp.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temp[i] >= temp[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return ans;
    }
}
