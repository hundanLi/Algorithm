package problems.linkedlist;

import explore.datastructure.linkedlist.ListNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-23 11:03
 **/
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode h = head;
        ListNode node;
        while (h.next != null) {
            if (h.val <= h.next.val) {
                h = h.next;
                continue;
            }
            node = h.next;
            h.next = node.next;
            node.next = null;
            head = insertNode(head, node);
        }
        return head;
    }

    private ListNode insertNode(ListNode head, ListNode node) {
        ListNode h = head;
        if (h.val > node.val) {
            node.next = h;
            return node;
        }
        while (h.next != null && h.next.val <= node.val) {
            h = h.next;
        }
        node.next = h.next;
        h.next = node;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode h = head;
        h.next = new ListNode(2);
        h = h.next;
        h.next = new ListNode(1);
        h = h.next;
        h.next = new ListNode(3);
        new InsertionSortList().insertionSortList(head);
    }
}
