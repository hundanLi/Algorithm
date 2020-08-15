package mock.month1909;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-01 09:23
 **/
public class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private Queue<Integer> temp;
    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
        temp = new ArrayDeque<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue1.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        while (queue1.size() > 1) {
            queue2.offer(queue1.remove());
        }
        int val = queue1.remove();
        temp = queue2;
        queue2 = queue1;
        queue1 = temp;
        return val;
    }

    /**
     * Get the top element.
     */
    public int top() {
        while (queue1.size() > 1) {
            queue2.offer(queue1.remove());
        }
        int val = queue1.remove();
        queue2.offer(val);
        temp = queue2;
        queue2 = queue1;
        queue1 = temp;
        return val;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());

    }
}
