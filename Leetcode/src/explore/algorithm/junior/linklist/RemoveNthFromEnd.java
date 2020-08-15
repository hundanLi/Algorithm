package explore.algorithm.junior.linklist;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-15 22:48
 **/
public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //n = 1
        if (n == 1) {
            ListNode p = head;
            if (p.next == null) {
                return null;
            }
            while (p.next.next != null) {
                p = p.next;
            }
            p.next = null;
            return head;
        }

        //快慢指针
        ListNode ahead = head;
        ListNode behind = head;
        int num = n;
        while (num-- != 0) {
            ahead = ahead.next;
        }
        while (ahead != null) {
            ahead = ahead.next;
            behind = behind.next;
        }

        behind.val = behind.next.val;
        behind.next = behind.next.next;
        return head;
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
        p = removeNthFromEnd(head, 1);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
