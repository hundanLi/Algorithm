package ctrip;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-04 19:29
 **/
public class LinkedListSort {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 请完成下面这个函数，实现题目要求的功能
     */
    private static ListNode partition(ListNode head,int m) {
        List<Integer> small = new ArrayList<>();
        List<Integer> big = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            if (p.val > m) {
                big.add(p.val);
            } else {
                small.add(p.val);
            }
            p = p.next;
        }
        p = head;
        for (int i : small) {
            p.val = i;
            p = p.next;
        }
        for (int i : big) {
            p.val = i;
            p = p.next;
        }
        return head;
    }
    /******************************结束写代码******************************/

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode head=null;
        ListNode node=null;
        int m=in.nextInt();
        while(in.hasNextInt()){
            int v=in.nextInt();
            if(head==null){
                node=new ListNode(v);
                head=node;
            }else{
                node.next=new ListNode(v);
                node=node.next;
            }
        }
        head= partition(head,m);
        if(head!=null){
            System.out.print(head.val);
            head=head.next;
            while(head!=null){
                System.out.print(",");
                System.out.print(head.val);
                head=head.next;
            }
        }
        System.out.println();
    }
}
