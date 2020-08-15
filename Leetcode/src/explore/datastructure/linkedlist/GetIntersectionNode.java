package explore.datastructure.linkedlist;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-31 09:48
 **/
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != null) {
            lenA++;
            pA = pA.next;
        }
        while (pB != null) {
            lenB++;
            pB = pB.next;
        }
        pA = headA;
        pB = headB;
        int diff = 0;
        if (lenA > lenB) {
            diff = lenA - lenB;
            while (diff-- > 0) {
                pA = pA.next;
            }
        } else {
            diff = lenB - lenA;
            while (diff-- > 0) {
                pB = pB.next;
            }
        }
        while (pA != pB) {
            pA = pA.next;
            pB = pB.next;
        }
        return pA;
    }
}
