package problems.linkedlist;

import explore.datastructure.linkedlist.ListNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-21 09:48
 **/
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode h = newHead;
        ListNode cur = head;
        ListNode next;
        while (cur != null && cur.next != null) {
            next = cur.next.next;
            h.next = swap(cur);
            h = h.next.next;
            cur = next;
        }
        if (cur != null) {
            h.next = cur;
        }
        return newHead.next;
    }

    private ListNode swap(ListNode h) {
        ListNode next = h.next;
        h.next = null;
        next.next = h;
        return next;
    }
}
