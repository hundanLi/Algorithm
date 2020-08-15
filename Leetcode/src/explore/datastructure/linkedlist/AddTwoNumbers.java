package explore.datastructure.linkedlist;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-01 10:20
 **/
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        int carry = 0;
        int val;
        while (l1 != null && l2 != null) {
            val = l1.val + l2.val + carry;
            carry = 0;
            if (val >= 10) {
                val -= 10;
                carry = 1;
            }
            p.next = new ListNode(val);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            val = l1.val + carry;
            carry = 0;
            if (val >= 10) {
                val -= 10;
                carry = 1;
            }
            p.next = new ListNode(val);
            p = p.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            val = l2.val + carry;
            carry = 0;
            if (val >= 10) {
                val -= 10;
                carry = 1;
            }
            p.next = new ListNode(val);
            p = p.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            p.next = new ListNode(carry);
        }

        return head.next;
    }
}
