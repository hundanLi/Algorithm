package problems.linkedlist;

import explore.datastructure.linkedlist.ListNode;
import explore.datastructure.tree.TreeNode;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-22 10:37
 **/
public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode midNode = findMidNode(head);
        TreeNode root = new TreeNode(midNode.val);
        // 提前终止条件：链表仅剩一个节点，即head == midNode
        if (head == midNode) {
            return root;
        }
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(midNode.next);
        return root;
    }

    private ListNode findMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode preSlow = null;
        while (fast != null && fast.next != null) {
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (preSlow != null) {
            preSlow.next = null;
        }
        return slow;
    }
}
