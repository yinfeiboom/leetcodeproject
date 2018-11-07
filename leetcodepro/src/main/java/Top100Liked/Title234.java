package Top100Liked;
/*
请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true
进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class Title234 {
    public static void main(String[] args){
        Title234 title234=new Title234();
       System.out.print( title234.isPalindrome(new ListNode(1)));
    }
    public boolean isPalindrome(ListNode head) {
        ListNode tail=head,pre=head,k=head;
        if(head==null) return true;
        int index=0;
        while (tail.next!=null){
            tail=tail.next;
            index++;

        }
        int s=0;
        tail=head;
        while (s<=index){
            pre=k;
            k=tail;
            tail=tail.next;

            if (s>index/2){
                k.next=pre;
            }
            s++;

        }
        s=0;
        pre=head;
        while (s<=index){
            if (pre.val!=k.val){
                return false;
            }
            pre=pre.next;
            k=k.next;
            s++;
        }
        return true;
    }


}
