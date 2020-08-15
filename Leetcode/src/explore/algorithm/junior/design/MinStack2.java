package explore.algorithm.junior.design;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-10 18:35
 **/
public class MinStack2 {
    private Stack<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack2() {
        stack = new Stack<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        Integer min = this.minStack.peekFirst();
        if (min == null || x <= min) {
            this.minStack.addFirst(x);
        }
    }

    public void pop() {
        int top = stack.pop();
        if (top == minStack.getFirst()) {
            minStack.pollFirst();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        return Integer.MAX_VALUE;
    }

}
