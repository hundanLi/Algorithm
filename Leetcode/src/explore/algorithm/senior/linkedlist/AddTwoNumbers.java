package explore.algorithm.senior.linkedlist;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-25 15:33
 **/
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(0);
        ListNode head = p;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;
        while (p1 != null && p2 != null) {
            int sum = p1.val + p2.val + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            p.next = new ListNode(sum);
            p = p.next;
            p1 = p1.next;
            p2 = p2.next;
        }

        while (p1 != null) {
            int sum = p1.val + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            p.next = new ListNode(sum);
            p = p.next;
            p1 = p1.next;
        }

        while (p2 != null) {
            int sum = p2.val + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            p.next = new ListNode(sum);
            p = p.next;
            p2 = p2.next;
        }
        if (carry != 0) {
            p.next = new ListNode(carry);
        }
        return head.next;
    }
}
