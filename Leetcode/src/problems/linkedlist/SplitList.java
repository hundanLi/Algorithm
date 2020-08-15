package problems.linkedlist;

import explore.datastructure.linkedlist.ListNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-12 15:03
 **/
public class SplitList {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode p = root;
        int n = 0;
        while (p != null) {
            n++;
            p = p.next;
        }
        int len = n / k;
        int m = 0;
        if (n > k && n > k * len) {
            m = n % k;
        }
        ListNode[] listNodes = new ListNode[k];
        p = root;
        for (int i = 0; i < k; i++) {
            if (p == null) {
                continue;
            }
            ListNode head = p;
            for (int j = 1; j < len; j++) {
                p = p.next;
            }
            if (m-- > 0) {
                p = p.next;
            }
            if (p != null) {
                ListNode temp = p.next;
                p.next = null;
                p = temp;
            }
            listNodes[i] = head;
        }
        return listNodes;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        for (int i = 1; i < 2; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        int k = 3;
        ListNode[] listNodes = new SplitList().splitListToParts(head.next, k);
        for (ListNode listNode : listNodes) {
            while (listNode != null) {
                System.out.print(listNode.val + " ");
                listNode = listNode.next;
            }
            System.out.println();
        }
    }
}
