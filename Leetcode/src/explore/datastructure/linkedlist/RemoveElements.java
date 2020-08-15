package explore.datastructure.linkedlist;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-31 10:26
 **/
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode pre = pHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                cur = cur.next;
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return pHead.next;
    }
}
