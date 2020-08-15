package problems.linkedlist;

import explore.datastructure.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-12 14:14
 **/
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        ListNode p = l1;
        while (p != null) {
            list1.add(p.val);
            p = p.next;
        }
        p = l2;
        while (p != null) {
            list2.add(p.val);
            p = p.next;
        }
        System.out.println(list1);
        System.out.println(list2);
        int i = list1.size() - 1;
        int j = list2.size() - 1;
        ListNode head = null;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int s;
            if (i < 0) {
                s = list2.get(j) + carry;
                carry = s / 10;
                s %= 10;
            } else if (j < 0) {
                s = list1.get(i) + carry;
                carry = s / 10;
                s %= 10;
            } else {
                s = list1.get(i) + list2.get(j) + carry;
                carry = s / 10;
                s %= 10;
            }
            if (head == null) {
                head = new ListNode(s);
            } else {
                ListNode temp = new ListNode(s);
                temp.next = head;
                head = temp;
            }
            i--;
            j--;
        }
        if (carry > 0) {
            ListNode temp = new ListNode(carry);
            temp.next = head;
            head = temp;
        }
        return head;
    }


}
