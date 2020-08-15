package explore.datastructure.linkedlist;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-30 10:18
 **/
public class MyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int length;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        head = new ListNode(-1);
        tail = head;
        length = 0;
    }

    /**
     * Get the value of the index-th node in the linked list.
     * If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= length) {
            return -1;
        }
        ListNode p = head.next;
        int k = 0;
        while (k < index) {
            k++;
            p = p.next;
        }
        return p.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode cur = new ListNode(val);
        cur.next = head.next;
        head.next = cur;
        if (tail == head) {
            tail = cur;
        }
        length++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        ListNode cur = new ListNode(val);
        tail.next = cur;
        tail = cur;
        length++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == length) {
            addAtTail(val);
        } else if (index < length) {

            int k = 0;
            ListNode p = head;
            while (k < index) {
                k++;
                p = p.next;
            }
            ListNode cur = new ListNode(val);
            cur.next = p.next;
            p.next = cur;
            length++;
        }

    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= 0 && index < length) {
            int k = 0;
            ListNode p = head;
            while (k < index) {
                k++;
                p = p.next;
            }
            if (p.next == tail) {
                tail = p;
            }
            p.next = p.next.next;
            length--;
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
            sb.append(p.val).append("->");
        }
        sb.append("null");
        return sb.toString();
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

    }


    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        System.out.println(linkedList);

        linkedList.addAtHead(1);
        System.out.println(linkedList);

        linkedList.addAtTail(3);
        System.out.println(linkedList);

        linkedList.addAtIndex(1, 2);
        System.out.println(linkedList);

        System.out.println(linkedList.get(1));
        System.out.println(linkedList);

        linkedList.deleteAtIndex(1);
        System.out.println(linkedList);

        System.out.println(linkedList.get(1));
        System.out.println(linkedList);

    }
}
