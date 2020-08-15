package explore.datastructure.linkedlist;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-01 11:09
 **/
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int length = 0;
        ListNode fast = head;
        while (fast != null) {
            length++;
            fast = fast.next;
        }
        k = (k) % length;
        if (k == 0) {
            return head;
        }
        fast = head;
        ListNode slow = head;
        while (k-- > 0) {
            fast = fast.next;
        }
        if (fast == null) {
            return head;
        }
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
