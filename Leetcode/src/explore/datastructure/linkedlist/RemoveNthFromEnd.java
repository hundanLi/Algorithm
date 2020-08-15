package explore.datastructure.linkedlist;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-31 09:57
 **/
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast = head;
        ListNode slow = head;
        if (n == 1) {
            fast = fast.next;
            while (fast != null && fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            if (fast == null) {
                return null;
            }
            slow.next = null;
            return head;
        }

        while (--n > 0) {
            fast = fast.next;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.val = slow.next.val;
        slow.next = slow.next.next;

        return head;
    }
}
