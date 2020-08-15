package explore.datastructure.linkedlist;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-31 11:12
 **/
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(1);
        ListNode evenHead = new ListNode(0);

        int k = 1;
        ListNode p = head;
        ListNode odd = oddHead;
        ListNode even = evenHead;

        while (p != null) {
            if ((k & 1) != 0) {
                odd.next = p;
                odd = p;
            } else {
                even.next = p;
                even = p;
            }
            p = p.next;
            k++;
        }
        odd.next = null;
        even.next = null;
        odd.next = evenHead.next;
        return oddHead.next;
    }
}
