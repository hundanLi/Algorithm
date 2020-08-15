package explore.datastructure.linkedlist;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-30 11:07
 **/
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
