package explore.algorithm.junior.linklist;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-16 10:56
 **/
public class ReverseList {
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode ahead = head;
        ListNode mid = head.next;
        ListNode behind = head.next.next;

        while (behind != null) {
            mid.next = ahead;
            ahead = mid;
            mid = behind;
            behind = behind.next;
        }
        mid.next = ahead;
        head.next = null;
        return mid;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int i = 1; i <= 5; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
//        p = head;
//        while (p != null) {
//            System.out.println(p.val);
//            p = p.next;
//        }

        //test
        p = reverseList(head);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
