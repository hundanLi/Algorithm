package problems.design;

import explore.datastructure.linkedlist.ListNode;

import java.util.List;
import java.util.Random;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-11 15:48
 **/
public class RandomNode {
    class Solution {
        private ListNode head;
        private int n;
        private Random random;
        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            random = new Random();
            this.head = head;
            ListNode p = head;
            while (p != null) {
                n++;
                p = p.next;
            }
        }

        /** Returns a random node's value. */
        public int getRandom() {
            int i = random.nextInt(n);
            ListNode p = head;
            while (--i >= 0) {
                p = p.next;
            }
            return p.val;
        }
    }
}
