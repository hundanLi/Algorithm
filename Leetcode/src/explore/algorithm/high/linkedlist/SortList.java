package explore.algorithm.high.linkedlist;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-21 20:33
 * 题目描述：在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 **/
public class SortList {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //左链表
        ListNode left = head;
        //右链表
        ListNode right = slow.next;
        //打断链表
        slow.next = null;
        left = mergeSort(left);
        right = mergeSort(right);

        //合并列表
        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            } else {
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            p.next = l1;
            p = p.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            p.next = l2;
            p = p.next;
            l2 = l2.next;
        }
        return head.next;
    }

}
