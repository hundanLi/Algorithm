package explore.datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-06 11:11
 **/
public class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (!queue1.isEmpty()) {
            queue1.offer(x);
        } else {
            queue2.offer(x);
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.remove());
            }
            return queue1.remove();
        } else {
            while (queue2.size() > 1) {
                queue1.offer(queue2.remove());
            }
            return queue2.remove();
        }
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.remove());
            }
            Integer top = queue1.remove();
            queue2.offer(top);
            return top;
        } else {
            while (queue2.size() > 1) {
                queue1.offer(queue2.remove());
            }
            Integer top = queue2.remove();
            queue1.offer(top);
            return top;
        }
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
