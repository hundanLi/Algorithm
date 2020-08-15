package mock.month1907;

import java.util.HashSet;
import java.util.Set;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-27 09:40
 * 记dp[i][j] 为h[0:i-1]和g[0:j-1]的组件长度，则
 * if h[i-1] 在 g[0:j-1]中，
 * dp[i][j] = dp[i-1][j] + 1
 * else
 * dp[i][j] = 0
 **/
public class NumComponents {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int numComponents(ListNode head, int[] list) {
        Set<Integer> set = new HashSet<>();
        for (int i : list) {
            set.add(i);
        }
        ListNode node = head;
        int cnt = 0;
        while (node != null) {
            if (set.contains(node.val)) {
                cnt++;
                while ((node = node.next) != null && set.contains(node.val)) {}
            }
            if (node == null) {
                return cnt;
            }
            node = node.next;
        }
        return cnt;
    }

}
