package problems.linkedlist;

import explore.datastructure.linkedlist.ListNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-13 13:09
 **/
public class ZeroSumSublists {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode ahead = new ListNode(-1);
        ListNode p = head;
        int n = 0;
        while (p != null) {
            n++;
            p = p.next;
        }
        int[] array = new int[n];
        n = 0;
        p = head;
        while (p != null) {
            array[n++] = p.val;
            p = p.next;
        }
        p = ahead;
        int i = 0;
        while (i < n) {
            int sum = 0;
            boolean flag = false;
            for (int j = i; j < n; j++) {
                sum += array[j];
                if (sum == 0) {
                    i = j + 1;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                p.next = new ListNode(array[i++]);
                p = p.next;
            }
        }
        return ahead.next;
    }

    public ListNode removeZeroSumSublists2(ListNode head) {
        ListNode ahead = new ListNode(-1);
        ListNode h = ahead;
        h.next = head;
        ListNode q = h.next;
        while (h.next != null) {
            int sum = 0;
            while (q != null) {
                sum += q.val;
                if (sum == 0) {
                    break;
                }
                q = q.next;
            }
            if (sum == 0) {
                // h.next至q之间的的连续子链表和等于0，那么删除这段子链表，亦即将h.next和q指针都指向q.next，进入下一层循环
                q = q.next;
                h.next = q;
            } else {
                // h.next开头的所有连续子链表累加和都不等于0，那么h.next节点应该保留，并继续从h.next.next开始检测
                h = h.next;
                q = h.next;
            }
        }
        return ahead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, -3, 3, 1};
        ListNode head = new ListNode(-1);
        ListNode p = head;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        new ZeroSumSublists().removeZeroSumSublists(head.next);
    }

}
