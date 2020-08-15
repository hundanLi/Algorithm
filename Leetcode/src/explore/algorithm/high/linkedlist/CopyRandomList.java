package explore.algorithm.high.linkedlist;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-21 21:45
 * 思路：先拷贝普通指针，再拷贝随机指针
 * （1）复制当前结点到下一节点
 * （2）添加随机指针：新的随机指针指向当前随机指针指向的下一节点
 * （3）分离原链表与新链表
 **/
public class CopyRandomList {
    public Node copyRandomList(Node head) {
        head = copyToNext(head);
        head = copyRandom(head);
        return separate(head);
    }
    
    private Node copyToNext(Node head) {
        Node p = head;
        while (p != null) {
            Node newNext = new Node(p.val, null, null);
            newNext.next = p.next;
            p.next = newNext;
            p = newNext.next;
        }
        return head;
    }

    private Node copyRandom(Node head) {
        Node p = head;
        Node copy;
        while (p != null) {
            copy = p.next;
            if (p.random != null) {
                copy.random = p.random.next;
            }
            p = copy.next;
        }
        return head;
    }

    private Node separate(Node head) {
        Node newHead = new Node();
        Node copy = newHead;
        Node p = head;
        while (p != null) {
            copy.next = p.next;
            copy = copy.next;
            p.next = copy.next;
            p = p.next;
        }
        return newHead.next;
    }

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
