package Top100Liked;
/*
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 */
public class Title21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res=new ListNode(-1);
        ListNode p1=l1,p2=l2,k=res;
        while (p1!=null&&p2!=null){
            if (p1.val>p2.val){
                k.next=p2;
                k=p2;
                p2=p2.next;
                k.next=null;
            }
            else {
                k.next=p1;
                k=p1;
                p1=p1.next;
                k.next=null;
            }
        }
        if (p1==null) k.next=p2;
        if (p2==null) k.next=p1;
        res=res.next;
          return res;
    }
}
