package explore.datastructure.queue;


/**
 * @author li
 * @version 1.0
 * @date 2019-06-01 11:53
 * 队列为空：head = tail;
 * 队列已满：(tail + 1) % cap = head
 * tail位置可以存放元素，但head位置留空
 **/
public class MyCircularQueue {
    private int[] elem;
    private int head;
    private int tail;
    private int capacity;
    /**
     * Initialize your data structure here.
     * Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        elem = new int[k + 1];
        head = 0;
        tail = 0;
        capacity = k + 1;
    }

    /**
     * Insert an element into the circular queue.
     * Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        tail = (tail + 1) % capacity;
        elem[tail] = value;
        return true;
    }

    /**
     * Delete an element from the circular queue.
     * Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head++;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return elem[(head + 1) % capacity];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return elem[tail];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return tail == head;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return (tail + 1) % capacity == head;
    }
}
