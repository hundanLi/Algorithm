package problems.linkedlist;

import explore.datastructure.linkedlist.ListNode;


/**
 * @author li
 * @version 1.0
 * @date 2019-10-21 10:35
 **/
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(-1);
        ListNode h = newHead;
        ListNode n = head;
        while (n != null) {
            n = deleteNodes(n);

            if (n != h.next) {
                h.next = n;
            } else {
                if (n == null) {
                    break;
                }
                n = n.next;
                h = h.next;
            }
        }
        return newHead.next;
    }

    private ListNode deleteNodes(ListNode h) {
        int val = h.val;
        ListNode n = h.next;
        while (n != null && n.val == val) {
            n = n.next;
        }
        return n != h.next ? n : h;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new DeleteDuplicates().deleteDuplicates(head);
    }

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return head;
            }
            if (head.next != null && head.val == head.next.val) {
                head = head.next;
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                return deleteDuplicates(head.next);
            } else {
                head.next = deleteDuplicates(head.next);
            }
            return head;
        }
    }
}

