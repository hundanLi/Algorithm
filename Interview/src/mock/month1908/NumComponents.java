package mock.month1908;


import java.util.HashSet;
import java.util.Set;

/**
 * @author li
 * @version 1.0
 * @date 2019-08-26 09:53
 **/
public class NumComponents {

    public int numComponents(ListNode head, int[] list) {

        Set<Integer> set = new HashSet<>();
        for (int n : list) {
            set.add(n);
        }
        ListNode node = head;
        int num = 0;
        while (node != null) {
            if (set.contains(node.val)) {
                num++;
                while ((node = node.next) != null && set.contains(node.val)) ;
            } else {
                node = node.next;
            }
            if (node == null) {
                break;
            }
        }
        return num;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
