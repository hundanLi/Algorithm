package explore.algorithm.junior.design;


import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-10 18:16
 **/
public class MinStack {
    private Stack<Integer> stack;
    private PriorityQueue<Integer> queue;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        queue = new PriorityQueue<>();
    }

    public void push(int x) {
        stack.push(x);
        queue.add(x);
    }

    public void pop() {
        if (!stack.isEmpty()) {
            Integer pop = stack.pop();
            queue.remove(pop);
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return Integer.MAX_VALUE;
    }

    public int getMin() {
        if (!queue.isEmpty()) {
            return queue.peek();
        }
        return Integer.MAX_VALUE;
    }

}
