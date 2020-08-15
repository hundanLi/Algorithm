package mock.month1909;


import datastructure.ListNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-24 09:13
 **/
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode oddHead = new ListNode(-1);
        ListNode odd = oddHead;
        ListNode evenHead = new ListNode(-1);
        ListNode even = evenHead;
        ListNode p = head;
        boolean isOdd = true;
        while (p != null) {
            if (isOdd) {
                isOdd = false;
                odd.next = p;
                odd = odd.next;
            } else {
                isOdd = true;
                even.next = p;
                even = even.next;
            }
            p = p.next;
        }
        even.next = null;
        odd.next = evenHead.next;
        return oddHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        for (int i = 1; i <= 5; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        p = new OddEvenList().oddEvenList(head.next);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
