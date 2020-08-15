package mock.month1908;

import datastructure.ListNode;


/**
 * @author li
 * @version 1.0
 * @date 2019-08-04 10:49
 **/
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        ListNode node = head;
        int len = 0;
        while (node != null) {
            len++;
            node= node.next;
        }
        k = k % len;
        ListNode fast = head;
        while (k-- > 0) {
            fast = fast.next;
        }
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
}
