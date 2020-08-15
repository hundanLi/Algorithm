package explore.datastructure.stack;

import java.util.Stack;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-06 11:06
 **/
public class MyQueue {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;
    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        pushStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return popStack.isEmpty() && pushStack.isEmpty();
    }
}
