package explore.datastructure.linkedlist;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-31 11:53
 **/
public class MyDeLinkedList {

    private ListNode head;
    private ListNode tail;
    private int length;

    /**
     * Initialize your data structure here.
     */
    public MyDeLinkedList() {
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
        while (index-- > 0) {
            p = p.next;
        }
        return p.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val);
        newHead.next = head.next;
        newHead.prev = head;
        if (head.next != null) {
            head.next.prev = newHead;
        } else {
            tail = newHead;
        }
        head.next = newHead;
        length++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        ListNode newTail = new ListNode(val);
        newTail.next = null;
        newTail.prev = tail;
        tail.next = newTail;
        tail = newTail;
        length++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {

        if (index > length) {
            return;
        }
        if (index < 0) {
            index = 0;
        }

        if (index == length) {
            addAtTail(val);
            return;
        }

        ListNode newNode = new ListNode(val);
        ListNode prev = head;
        ListNode next;
        while (index-- > 0) {
            prev = prev.next;
        }
        next = prev.next;
        newNode.next = next;
        newNode.prev = prev;
        prev.next = newNode;
        next.prev = newNode;
        length++;
    }

    /**
     * Delete the index-th node in the linked list,
     * if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length) {
            return;
        }
        ListNode toDelete = head.next;
        while (index-- > 0) {
            toDelete = toDelete.next;
        }
        if (toDelete == tail) {
            toDelete.prev.next = null;
            tail = toDelete.prev;
        } else {
            toDelete.next.prev = toDelete.prev;
            toDelete.prev.next = toDelete.next;
        }
        length--;
    }


    private static class ListNode {
        int val;
        ListNode prev;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

}
