package problems.bitwise;

import explore.datastructure.linkedlist.ListNode;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-18 10:29
 **/
public class GetDecimalValue {
    public int getDecimalValue(ListNode head) {
        int val = 0;
        ListNode p = head;
        while (p != null) {
            val = val << 1 | p.val;
            p = p.next;
        }
        return val;
    }
}
