package problems.linkedlist;


/**
 * @author li
 * @version 1.0
 * @date 2019-10-08 10:42
 **/
public class ReverseBetween {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n) {
            return head;
        }
        ListNode prev = null;
        ListNode tail = null;
        ListNode p = head;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        if (m == 1) {
            prev = newHead;
        }
        for (int i = 1; i <= n; i++) {
            if (i == m - 1) {
                prev = p;
            }
            if (i == n) {
                tail = p;
                break;
            }
            p = p.next;
        }
        prev.next = reverse(prev.next, tail);
        return newHead.next;
    }


    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode p = head.next;
        ListNode q;
        ListNode tailNext = tail.next;
        while (p != tailNext) {
            q = p.next;
            p.next = newHead.next;
            newHead.next = p;
            p = q;
        }
        head.next = tailNext;
        return newHead.next;
    }

    static public void main(String[] args) {
        System.out.println("1");
    }
}
