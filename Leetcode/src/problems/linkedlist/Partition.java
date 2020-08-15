package problems.linkedlist;

import explore.datastructure.linkedlist.ListNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-21 17:33
 **/
public class Partition {
    public ListNode partition(ListNode head, int x) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode h = newHead;
        while (h.next != null && h.next.val < x) {
            h = h.next;
        }
        if (h.next == null) {
            return head;
        }
        // h.next.val >= x
        ListNode node = h;
        while (node.next != null) {
            if (node.next.val < x) {
                ListNode nextNode = node.next.next;
                node.next.next = h.next;
                h.next = node.next;
                h = h.next;
                node.next = nextNode;
            } else {
                node = node.next;
            }
        }
        return newHead.next;
    }
}
