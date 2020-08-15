package problems.linkedlist;

import explore.datastructure.linkedlist.ListNode;

import java.util.Stack;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-13 12:53
 **/
public class NextLargerNodes {

    private static class Pair {
        int i;
        int val;

        Pair(int i, int val) {
            this.i = i;
            this.val = val;
        }
    }
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<Pair> stack = new Stack<>();
        ListNode p = head;
        int n = 0;
        while (p != null) {
            n++;
            p = p.next;
        }
        int[] ans = new int[n];
        p = head;
        int i = 0;
        while (p != null) {
            while (!stack.isEmpty() && stack.peek().val < p.val) {
                ans[stack.pop().i] = p.val;
            }
            stack.push(new Pair(i++, p.val));
            p = p.next;
        }
        while (!stack.isEmpty()) {
            ans[stack.pop().i] = 0;
        }
        return ans;
    }
}
