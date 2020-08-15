package mock.month1909;


import datastructure.ListNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-06 09:09
 **/
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2 || head == null) {
            return head;
        }
        ListNode p = head;
        ListNode newHead = null;
        ListNode newTail = null;
        while (p != null) {
            ListNode q = p;
            ListNode tail;
            int i = k;
            while (--i > 0 && p.next != null) {
                p = p.next;
            }
            tail = q;
            ListNode next = p.next;
            if (i == 0) {
                ListNode node = reverseList(q, p);
                if (newHead == null) {
                    newHead = node;
                    newTail = tail;
                } else {
                    newTail.next = node;
                    newTail = tail;
                }
            } else {
                if (newHead == null) {
                    return head;
                } else {
                    newTail.next = q;
                }
                break;
            }
            p = next;

        }
        return newHead;
    }

    private ListNode reverseList(ListNode begin, ListNode end) {
        ListNode p = begin.next;
        ListNode q = begin;
        begin.next = null;
        while (p != end) {
            ListNode tmp = p.next;
            p.next = q;
            q = p;
            p = tmp;
        }
        end.next = q;
        return end;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode p = head.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(5);
        p = new ReverseKGroup().reverseKGroup(head, 3);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
