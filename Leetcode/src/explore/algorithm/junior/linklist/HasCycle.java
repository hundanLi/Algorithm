package explore.algorithm.junior.linklist;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-18 00:13
 **/
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) {
                return true;
            }
        }
        return false;
    }
}
