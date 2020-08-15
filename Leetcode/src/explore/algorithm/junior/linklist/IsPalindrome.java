package explore.algorithm.junior.linklist;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-16 16:41
 **/
public class IsPalindrome {
    public static boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        int[] elems = new int[len];
        p = head;
        int i = 0;
        while (i < len) {
            elems[i] = p.val;
            p = p.next;
            i++;
        }
        int j = 0, k = len - 1;
        while (j < k) {
            if (elems[j] != elems[k]) {
                return false;
            } else {
                j++;
                k--;
            }
        }
        return true;
    }

}
