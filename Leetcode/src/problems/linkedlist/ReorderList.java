package problems.linkedlist;

import explore.datastructure.linkedlist.ListNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-23 10:33
 **/
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode post = slow.next;
        slow.next = null;
        post = reverse(post);
        head = merge(head, post);
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode h = new ListNode(-1);
        ListNode node = h;
        boolean flag = true;
        while (h1 != null && h2 != null) {
            if (flag) {
                flag = false;
                node.next = h1;
                h1 = h1.next;
            } else {
                flag = true;
                node.next = h2;
                h2 = h2.next;
            }
            node = node.next;
        }
        if (h1 != null) {
            node.next = h1;
        }
        if (h2 != null) {
            node.next = h2;
        }
        return h.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
