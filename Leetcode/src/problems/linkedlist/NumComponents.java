package problems.linkedlist;

import explore.datastructure.linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-13 11:10
 **/
public class NumComponents {
    public int numComponents(ListNode head, int[] g) {
        if (head == null) {
            return 0;
        }
        ListNode p = head;
        Set<Integer> set = new HashSet<>();
        for (int i : g) {
            set.add(i);
        }
        int ans = 0;
        while (p != null) {
            if (set.contains(p.val) && (p.next == null || !set.contains(p.next.val))) {
                ans++;
            }
            p = p.next;
        }
        return ans;
    }
}
