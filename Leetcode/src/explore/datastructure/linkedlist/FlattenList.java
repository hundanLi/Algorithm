package explore.datastructure.linkedlist;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-01 10:32
 **/
public class FlattenList {
    public Node flatten(Node head) {
        Node[] nodes = flattenChild(head);
        return nodes != null ? nodes[0] : null;
    }

    private Node[] flattenChild(Node childHead) {
        if (childHead == null) {
            return null;
        }
        Node p = childHead;
        Node tail = childHead;
        while (p != null) {
            if (p.child != null) {
                Node[] newNext = flattenChild(p.child);
                newNext[1].next = p.next;
                if (p.next != null) {
                    p.next.prev = newNext[1];
                }
                p.next = newNext[0];
                newNext[0].prev = p;
                p.child = null;
            }
            tail = p;
            p = p.next;
        }
        return new Node[]{childHead, tail};
    }
}
