package Top100Liked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
编写一个程序，找到两个单链表相交的起始节点。



例如，下面的两个链表：

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3
在节点 c1 开始相交。



注意：

如果两个链表没有交点，返回 null.
在返回结果后，两个链表仍须保持原有的结构。
可假定整个链表结构中没有循环。
程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class Title160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        List<ListNode> listNodeList=new ArrayList<>();
        ListNode a=headA;
        ListNode b=headB;
        while(a!=null){
            listNodeList.add(a);
            a=a.next;
        }
        while (b!=null){
            if (listNodeList.contains(b)) return b;
            b=b.next;
        }
return null;



       /* ListNode taila=get(headA);
        ListNode b=headB;
        ListNode res=null;
        while (b!=null){

            if (b==b.next){
             res=b;
             break;
            }
            else b=b.next;
        }
        get(taila);
        return res;
        */
    }
    //反转链表
    public ListNode get(ListNode headA){
        ListNode cur=headA;
        ListNode pre=headA,k=null;

        while (cur!=null||cur==cur.next){
            k=cur;
            cur=cur.next;
            k.next=pre;
            pre=k;
        }
        return k;
    }
}
