package explore.algorithm.senior.linkedlist;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-25 16:27
 **/
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        int lenA = 0;
        int lenB = 0;
        while (a != null) {
            lenA++;
            a = a.next;
        }
        while (b != null) {
            lenB++;
            b = b.next;
        }
        a = headA;
        b = headB;
        if (lenA > lenB) {
            int l = lenA - lenB;
            while (l-- > 0) {
                a = a.next;
            }
        } else {
            int l = lenB - lenA;
            while (l-- > 0) {
                b = b.next;
            }
        }
        while (a != null && b != null) {
            if (a.equals(b)) {
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return null;
    }
}
