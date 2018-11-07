package Top100Liked;

import java.math.BigDecimal;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

 */
public class Title2 {

    public static void main(String[] args){
        Title2 t2=new Title2();
        ListNode node1=new ListNode(9);

        ListNode node11=new ListNode(1);
        ListNode node22=new ListNode(9);
        ListNode node33=new ListNode(9);
        ListNode node2=new ListNode(9);
        ListNode node3=new ListNode(9);
        ListNode node41=new ListNode(9);
        ListNode node42=new ListNode(9);
        ListNode node43=new ListNode(9);
        ListNode node44=new ListNode(9);
        ListNode node45=new ListNode(9);
        node11.next=node22;
        node22.next=node33;
        node33.next=node2;
        node2.next=node3;
        node3.next=node41;
        node41.next=node42;
        node42.next=node43;
        node43.next=node44;
        node44.next=node45;


       ListNode res= t2.addTwoNumbers2(node1,node11);
       System.out.print(res.val);
    }
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int falg=0;
        ListNode head=new ListNode(0);
        ListNode p=head;
        int num1=0,num2=0;
        while (l1!=null||l2!=null||falg==1){
            if (l1!=null)num1=l1.val;
            else num1=0;
            if(l2!=null) num2=l2.val;
            else num2=0;
            int sum=num1+num2+falg;
            falg=0;
            if (sum>=10){
                sum=sum%10;
                falg=1;
            }
            ListNode node=new ListNode(sum);
            p.next=node;
            p=node;

            if (l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;

    }
        head=head.next;
        return head;
    }
}
