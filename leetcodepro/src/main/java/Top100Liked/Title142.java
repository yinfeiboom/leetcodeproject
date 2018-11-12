package Top100Liked;

import java.util.ArrayList;
import java.util.List;

/*
给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

说明：不允许修改给定的链表。

进阶：
你是否可以不用额外空间解决此题？
 */
public class Title142 {


    public ListNode detectCycle(ListNode head) {
        List<ListNode> list=new ArrayList<>();
        ListNode p=head;
        while (p!=null){
            if (list.contains(p)) return p;
            else {
                list.add(p);
                p=p.next;
            }
        }
        return null;
    }


    //进阶算法
    public ListNode detectCycle_better(ListNode head) {

        ListNode fast=head,slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (fast == slow) {
                ListNode slow2 = head;
                while (slow2 != slow) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
    return null;

    }

}
