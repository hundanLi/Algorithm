package explore.algorithm.senior.linkedlist;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-25 16:10
 **/
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode oddHead = new ListNode(0);
        ListNode odd = oddHead;
        ListNode evenHead = new ListNode(0);
        ListNode even = evenHead;
        ListNode fast = head;
        ListNode slow = head.next;
        while (slow != null) {
            odd.next = fast;
            odd = odd.next;
            if (fast.next != null) {
                fast = fast.next.next;
            }
            even.next = slow;
            even = even.next;
            if (slow.next != null) {
                slow = slow.next.next;
            } else {
                slow = null;
            }
        }
        if (fast != null) {
            even.next = null;
            odd.next = fast;
            odd = odd.next;
        }
        odd.next = evenHead.next;
        return oddHead.next;
    }

    public ListNode oddEvenList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
