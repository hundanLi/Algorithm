package explore.datastructure.linkedlist;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-01 10:34
 **/
public class Node {
    int val;
    Node prev;
    Node next;
    Node child;

    public Node() {
    }

    public Node(int val, Node prev, Node next, Node child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }
}
