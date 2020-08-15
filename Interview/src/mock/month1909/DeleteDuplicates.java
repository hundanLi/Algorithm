package mock.month1909;

import datastructure.ListNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-24 19:32
 **/
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode next = head.next;
        while (next != null) {
            if (cur.val == next.val) {
                next = next.next;
                cur.next = next;
            } else {
                cur = next;
                next = next.next;
            }
        }
        return head;
    }
}
