package explore.datastructure.linkedlist;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-31 10:18
 **/
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode oldHead = head;
        ListNode newHead;
        while (oldHead != null && oldHead.next != null) {
            newHead = oldHead.next;
            oldHead.next = newHead.next;
            newHead.next = head;
            head = newHead;
        }
        return head;
    }
}
