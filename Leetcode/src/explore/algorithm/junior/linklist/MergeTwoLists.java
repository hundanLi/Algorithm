package explore.algorithm.junior.linklist;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-16 15:45
 **/
public class MergeTwoLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p;
        if (l1.val < l2.val) {
            p = l1;
            p1 = p1.next;
        } else {
            p = l2;
            p2 = p2.next;
        }
        ListNode head = p;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p = p.next;
                p1 = p1.next;
            } else {
                p.next = p2;
                p = p.next;
                p2 = p2.next;
            }
        }
        while (p1 != null) {
            p.next = p1;
            p = p.next;
            p1 = p1.next;
        }
        while (p2 != null) {
            p.next = p2;
            p = p.next;
            p2 = p2.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(0);
        ListNode p = head1;
        for (int i = 2; i <= 5; i+=2) {
            p.next = new ListNode(i);
            p = p.next;
        }
        ListNode head2 = new ListNode(1);
        p = head2;
        for (int i = 3; i <= 5; i+=2) {
            p.next = new ListNode(i);
            p = p.next;
        }

        //test
        p = mergeTwoLists(head1, head2);

        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
