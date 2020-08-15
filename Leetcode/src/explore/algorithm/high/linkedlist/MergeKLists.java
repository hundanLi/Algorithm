package explore.algorithm.high.linkedlist;

import javax.sound.midi.MidiChannel;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-20 18:57
 *
 * 思路一：先把第二条链表合并到第一条，再把第三条链表合并到第一条，以此类推；
 * 思路二：维护一个指针数组代表遍历到每条链表的位置，循环更新指针数组直到全部元素为null
 * 思路三：分治法合并，与第一类似
 **/
public class MergeKLists {
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode rsHead = lists[0];
        for (int i = 1; i < lists.length; i++) {
            rsHead = merge(rsHead, lists[i]);
        }
        return rsHead;
    }
    public ListNode mergeKLists2(ListNode[] lists) {
        //结果链表头
        ListNode head = new ListNode(0);
        ListNode p = head;
        //指针数组，初始化为各链表头
        ListNode[] pointers = new ListNode[lists.length];
        System.arraycopy(lists, 0, pointers, 0, pointers.length);
        //遍历指针数组元素，寻找最小值并更新对应的指针
        while (true) {
            ListNode minNode = null;
            int index = -1;
            //find min and index
            for (int i = 0; i < pointers.length; i++) {
                if (pointers[i] == null) {
                    continue;
                }
                if (minNode == null || minNode.val > pointers[i].val) {
                    minNode = pointers[i];
                    index = i;
                }
            }
            p.next = minNode;
            p = p.next;
            if (index == -1) {
                break;
            }
            pointers[index] = pointers[index].next;

        }
        return head.next;
    }

    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return sort(lists, 0, lists.length - 1);
    }

    private ListNode sort(ListNode[] listNodes, int begin, int end) {
        if (begin == end) {
            return listNodes[begin];
        }
        int mid = (begin + end) / 2;
        ListNode sort1 = sort(listNodes, begin, mid);
        ListNode sort2 = sort(listNodes, mid + 1, end);
        return merge(sort1, sort2);
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
