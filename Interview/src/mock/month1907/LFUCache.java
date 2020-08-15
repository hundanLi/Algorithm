package mock.month1907;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-22 00:20
 **/
public class LFUCache {
    // https://www.jianshu.com/p/437f53341f67
    // two layers of double linked list
    // one layer represents frequency
    // inner layer represents visit time
    private static class Node {
        int key;
        int value;
        int frequency = 0;
        Node next;
        Node prev;
        // which NodeQueue it belongs to
        NodeQueue nq;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static class NodeQueue {
        NodeQueue next;
        NodeQueue prev;
        Node tail;
        Node head;

        NodeQueue(NodeQueue next, NodeQueue prev, Node tail, Node head) {
            this.next = next;
            this.prev = prev;
            this.tail = tail;
            this.head = head;
        }
    }


    private NodeQueue tail;
    private int capacity;
    private HashMap<Integer, Node> map;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }

    // move current node to next NodeQueue with frequency++
    private void oneStepUp(Node n) {
        n.frequency++;
        boolean singleNodeQueue = false;
        // NodeQueue which n belongs to has only one Node n
        if (n.nq.head == n.nq.tail) {
            singleNodeQueue = true;
        }
        if (n.nq.next != null) {
            if (n.nq.next.tail.frequency == n.frequency) {
                // move n to n.nq.next
                removeNode(n);
                // insert n to head of new NodeQueue
                n.prev = n.nq.next.head;
                n.nq.next.head.next = n;
                n.nq.next.head = n;
                n.nq = n.nq.next;
            } else if (n.nq.next.tail.frequency > n.frequency) {
                // insert a new NodeQueue between n.nq and n.nq.next
                if (!singleNodeQueue) {
                    removeNode(n);
                    NodeQueue newnq = new NodeQueue(n.nq.next, n.nq, n, n);
                    n.nq.next.prev = newnq;
                    n.nq.next = newnq;
                    n.nq = newnq;
                }
                // if NodeQueue which n belongs to has only one Node n, only need to frequency++
            }
        } else {
            //NodeQueue which n belongs to is the head of out layer linked list, so insert new NodeQueue to head of out layer linked list
            if (!singleNodeQueue) {
                removeNode(n);
                NodeQueue newnq = new NodeQueue(null, n.nq, n, n);
                n.nq.next = newnq;
                n.nq = newnq;
            }
            // if NodeQueue which n belongs to has only one Node n, only need to frequency++
        }
    }

    // remove n from current NodeQuequ
    private Node removeNode(Node n) {
        // if NodeQueue only has one Node n, remove entire NodeQueue
        if (n.nq.head == n.nq.tail) {
            removeNQ(n.nq);
            return n;
        }
        if (n.prev != null) {
            n.prev.next = n.next;
        }
        if (n.next != null) {
            n.next.prev = n.prev;
        }
        if (n.nq.head == n) {
            n.nq.head = n.prev;
        }
        if (n.nq.tail == n) {
            n.nq.tail = n.next;
        }
        n.prev = null;
        n.next = null;
        return n;
    }

    private void removeNQ(NodeQueue nq) {
        if (nq.prev != null) {
            nq.prev.next = nq.next;
        }
        if (nq.next != null) {
            nq.next.prev = nq.prev;
        }
        if (this.tail == nq) {
            this.tail = nq.next;
        }
    }


    public int get(int key) {
        Node n = map.get(key);
        if (n == null) {
            return -1;
        }
        oneStepUp(n);
        return n.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node cn = map.get(key);
        if (cn != null) {
            cn.value = value;
            oneStepUp(cn);
            return;
        }
        // if reach capacity
        if (map.size() == capacity) {
            //remove node from tail of inner linkedlist from tail of out linkedlist
            map.remove(removeNode(this.tail.tail).key);
        }
        // insert new Node
        Node n = new Node(key, value);
        if (this.tail == null) {
            // cache is empty
            NodeQueue nq = new NodeQueue(null, null, n, n);
            this.tail = nq;
            n.nq = nq;
        } else if (this.tail.tail.frequency == 0) {
            // insert n to head of this.tail
            n.prev = this.tail.head;
            this.tail.head.next = n;
            n.nq = this.tail;
            this.tail.head = n;
        } else {
            // create new NodeQueue and insert to this.tail
            NodeQueue nq = new NodeQueue(this.tail, null, n, n);
            this.tail.prev = nq;
            this.tail = nq;
            n.nq = nq;
        }


        map.put(key, n);
    }
}

