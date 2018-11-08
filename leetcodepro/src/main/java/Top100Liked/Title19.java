package Top100Liked;

import java.util.List;

/*
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？
 */
public class Title19 {
    public static void main(String[] args){
        ListNode node1=new ListNode(1);

        ListNode node11=new ListNode(2);
        ListNode node22=new ListNode(3);
        ListNode node33=new ListNode(4);
        ListNode node2=new ListNode(5);
//        node1.next=node11;
//        node11.next=node22;
//        node22.next=node33;
//        node33.next=node2;
        Title19 title19=new Title19();
        System.out.println(title19.removeNthFromEnd(node1,1).val);
    }
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        /*one pass
        我们可以使用两个指针而不是一个指针。第一个指针从列表的开头向前移动 n+1n+1 步，而第二个指针将从列表的开头出发。现在，这两个指针被 n个结点分开。
        我们通过同时移动两个指针向前来保持这个恒定的间隔，直到第一个指针到达最后一个结点。此时第二个指针将指向从最后一个结点数起的第 n 个结点。我们重新链接第二个指针所引用的结点的 next 指针指向该结点的下下个结点
        */
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p=head;
        int len=0;
        while (p!=null){
            len++;
            p=p.next;
        }
        int del=len-n+1;
        len=1;
        ListNode delnode=head;
        p=null;
        while (len<del){
            p=delnode;
            delnode=delnode.next;
            len++;
        }
        if (delnode==head) return head.next;
        p.next=delnode.next;
        return head;
    }
}
